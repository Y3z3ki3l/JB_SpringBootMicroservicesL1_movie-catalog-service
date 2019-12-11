package io.javabrains.franniel.moviecatalogservice.models;

public class Rating {
	
	private String movieId;
	private int rating;
	
	/**
	 * 
	 */
	public Rating(String movieId, int rating) {
		this.movieId = movieId;
		this.rating = rating;
	}
	
	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
