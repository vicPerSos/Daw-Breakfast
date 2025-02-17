package com.breakfast.daw.web.controllers;

import com.breakfast.daw.persintence.entities.Review;
import com.breakfast.daw.services.ReviewService;
import com.breakfast.daw.services.dto.ReviewDTO;
import com.breakfast.daw.services.mapper.ReviewMapper;
import com.breakfast.daw.services.mapper.UsuarioMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        List<ReviewDTO> reviewsDTO = new ArrayList<ReviewDTO>();
        for (Review review : reviews) {
            reviewsDTO.add(ReviewMapper.toDTO(review));
        }

        return ResponseEntity.ok(reviewsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable int id) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            return ResponseEntity.ok(ReviewMapper.toDTO(review.get()));
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByUsuario(@PathVariable int usuarioId) {
        List<Review> reviews = reviewService.getReviewsByUsuario(usuarioId);
        List<ReviewDTO> reviewsDTO = new ArrayList<ReviewDTO>();
        for (Review review : reviews) {
            reviewsDTO.add(ReviewMapper.toDTO(review));
        }
        return ResponseEntity.ok(reviewsDTO);
    }

    @GetMapping("/desayuno/{desayunoId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByDesayuno(@PathVariable int desayunoId) {
        List<Review> reviews = reviewService.getReviewsByDesayuno(desayunoId);
        List<ReviewDTO> reviewsDTO = new ArrayList<ReviewDTO>();
        for (Review review : reviews) {
            reviewsDTO.add(ReviewMapper.toDTO(review));
        }
        return ResponseEntity.ok(reviewsDTO);
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(ReviewMapper.toDTO(reviewService.createReview(review)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable int id, @RequestBody Review review) {
        return ResponseEntity.ok(ReviewMapper.toDTO(reviewService.updateReview(id, review)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDTO> deleteReview(@PathVariable int id) {
        return ResponseEntity.ok(ReviewMapper.toDTO(this.reviewService.deleteReview(id)));
    }

    @GetMapping("/ordenadas/fecha/asc")
    public List<ReviewDTO> getReviewsOrderedByDateAsc() {
        List<Review> reviews = reviewService.getReviewsOrderedByDateAsc();
        List<ReviewDTO> reviewsDTO = new ArrayList<>();
        for (Review review : reviews) {
            reviewsDTO.add(ReviewMapper.toDTO(review));
        }
        return reviewsDTO;
    }

    @GetMapping("/ordenadas/fecha/desc")
    public List<ReviewDTO> getReviewsOrderedByDateDesc() {
        List<Review> reviews = reviewService.getReviewsOrderedByDateDesc();
        List<ReviewDTO> reviewsDTO = new ArrayList<>();
        for (Review review : reviews) {
            reviewsDTO.add(ReviewMapper.toDTO(review));
        }
        return reviewsDTO;
    }

    @GetMapping("/ordenadas/puntuacion")
    public List<ReviewDTO> getReviewsOrderedByScore() {
        List<Review> reviews = reviewService.getReviewsOrderedByScore();
        List<ReviewDTO> reviewsDTO = new ArrayList<>();
        for (Review review : reviews) {
            reviewsDTO.add(ReviewMapper.toDTO(review));
        }
        return reviewsDTO;
    }
}
