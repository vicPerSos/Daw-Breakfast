package com.breakfast.daw.services;

import com.breakfast.daw.persintence.entities.Review;
import com.breakfast.daw.persintence.entities.Desayuno;
import com.breakfast.daw.persintence.entities.Usuario;
import com.breakfast.daw.persintence.repositories.ReviewRepository;
import com.breakfast.daw.persintence.repositories.UsuarioRepository;
import com.breakfast.daw.persintence.repositories.DesayunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final DesayunoRepository desayunoRepository;
    private final UsuarioRepository usuarioRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByDesayuno(int id) {
        Desayuno desayuno = this.desayunoRepository.findById(id).get();
        return reviewRepository.findByDesayuno(desayuno);
    }

    public List<Review> getReviewsByUsuario(int usuarioId) {

        Usuario usuario = this.usuarioRepository.findById(usuarioId).get();
        return reviewRepository.findByUsuario(usuario);
    }

    @Transactional
    public Review createReview(Review review) {
        if (review.getPuntuacion() > 5 || review.getPuntuacion() < 1) {
            throw new RuntimeException("La puntuación debe estar entre 1 y 5");
        }
        Review savedReview = reviewRepository.save(review);
        actualizarPuntuacionDesayuno(review.getDesayuno());
        return savedReview;
    }

    @Transactional
    public Review updateReview(int id, Review review) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review no encontrada"));
        existingReview.setPuntuacion(review.getPuntuacion());
        existingReview.setComentario(review.getComentario());
        Review updatedReview = reviewRepository.save(existingReview);
        actualizarPuntuacionDesayuno(existingReview.getDesayuno());
        return updatedReview;
    }

    @Transactional
    public Review deleteReview(int id) {
        if (this.reviewRepository.existsById(id)) {
            Review review = reviewRepository.findById(id).get();
            this.reviewRepository.deleteById(id);
            return review;
        }

        return null;

    }

    public List<Review> getReviewsOrderedByDateAsc() {
        return reviewRepository.findAllByOrderByIdAsc();
    }

    public List<Review> getReviewsOrderedByDateDesc() {
        return reviewRepository.findAllByOrderByIdDesc();
    }

    public List<Review> getReviewsOrderedByScore() {
        return reviewRepository.findAllByOrderByPuntuacionDesc();
    }

    private void actualizarPuntuacionDesayuno(Desayuno desayuno) {
        List<Review> reviews = reviewRepository.findByDesayuno(desayuno);
        double promedio = reviews.stream()
                .mapToInt(Review::getPuntuacion)
                .average()
                .orElse(0.0);
        desayuno.setPuntuacion(promedio);
        desayunoRepository.save(desayuno);
    }
}
