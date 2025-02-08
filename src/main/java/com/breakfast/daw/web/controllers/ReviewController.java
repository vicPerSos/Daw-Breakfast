package com.breakfast.daw.web.controllers;

import com.breakfast.daw.persintence.entities.Review;
import com.breakfast.daw.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Review> getReviewsByUsuario(@PathVariable int usuarioId) {
        return reviewService.getReviewsByUsuario(usuarioId);
    }

    @GetMapping("/desayuno/{desayunoId}")
    public List<Review> getReviewsByDesayuno(@PathVariable int desayunoId) {
        return reviewService.getReviewsByDesayuno(desayunoId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ordenadas/fecha/asc")
    public List<Review> getReviewsOrderedByDateAsc() {
        return reviewService.getReviewsOrderedByDateAsc();
    }

    @GetMapping("/ordenadas/fecha/desc")
    public List<Review> getReviewsOrderedByDateDesc() {
        return reviewService.getReviewsOrderedByDateDesc();
    }

    @GetMapping("/ordenadas/puntuacion")
    public List<Review> getReviewsOrderedByScore() {
        return reviewService.getReviewsOrderedByScore();
    }
}
