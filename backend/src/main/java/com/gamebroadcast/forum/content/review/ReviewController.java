package com.gamebroadcast.forum.content.review;

import com.gamebroadcast.forum.content.review.models.ReviewAddUpdate;
import com.gamebroadcast.forum.content.review.models.ReviewFullInfoVM;
import com.gamebroadcast.forum.content.review.models.ReviewVM;
import com.gamebroadcast.forum.exceptions.ApiRequestException;
import com.gamebroadcast.forum.exceptions.NoEditRightsException;
import com.gamebroadcast.forum.utils.SessionUtils;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping(path = "api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewVM> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping(path = "/Similar/{reviewId}")
    public List<ReviewVM> getAllReviews(@PathVariable("reviewId") Long reviewId) {
        return reviewService.getSimilarReviews(reviewId);
    }

    @GetMapping(path = "/{reviewId}")
    public ReviewVM getReview(@PathVariable("reviewId") Long reviewId) {
        try {
            return reviewService.getReviewById(reviewId);
        } catch (RuntimeException e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    @GetMapping(path = "/FullInfo/{reviewId}")
    public ReviewFullInfoVM getReviewFullInfo(@PathVariable("reviewId") Long reviewId) {
        try {
            return reviewService.getReviewFullInfoById(reviewId);
        } catch (RuntimeException e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasRole('EDITOR')")
    public void addReview(@RequestBody ReviewAddUpdate newReview) {
        try {
            reviewService.addReview(newReview, newReview.content);
        } catch (RuntimeException e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    @PutMapping(path = "/{reviewId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('EDITOR')")
    public void updateReview(@PathVariable("reviewId") Long reviewId, @RequestBody ReviewAddUpdate reviewUpdate) {
        try {
            if (!sessionUserCanEditReview(reviewId)) {
                throw new NoEditRightsException("review");
            }
            reviewService.updateReview(reviewId, reviewUpdate);
        } catch (RuntimeException e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{reviewId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('EDITOR')")
    public void deleteReview(@PathVariable("reviewId") Long reviewId) {
        try {
            if (!sessionUserCanDeleteReview(reviewId)) {
                throw new NoEditRightsException("review");
            }
            reviewService.deleteReview(reviewId);
        } catch (RuntimeException e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    private boolean sessionUserCanEditReview(Long id) {
        return reviewService.sessionUserIsOwner(id);
    }

    private boolean sessionUserCanDeleteReview(Long id) {
        return reviewService.sessionUserIsOwner(id) || SessionUtils.getUserFromSession().getRole().equals("ADMIN");
    }
}