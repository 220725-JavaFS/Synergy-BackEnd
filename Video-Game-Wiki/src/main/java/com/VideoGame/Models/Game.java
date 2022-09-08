package com.VideoGame.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
	
	private int id;
	private int age_ratings; //Array of Integers
	private int category;
	private int collection;
	private int cover;
	private int created_at;
	private int external_games; //Array of Integers
	private int first_release_date;
	private int franchises; //Array of Integers
	private int game_modes; //Array of Integers
	private int genres; //Array of Integers
	private int involved_companies; //Array of Integers
	private int keywords; //Array of Integers
	private String name;
	private int platforms; //Array of Integers
	private int player_perspectives; //Array of Integers
	private int rating; 
	private int rating_count;
	private int release_dates; //Array of Integers
	private int screenshots; //Array of Integers
	private int similar_games;
	private String slug;
	private String summary;
	private int tags; //Array of Integers
	private int themes; //Array of Integers
	private int total_rating;
	private int total_rating_count;
	private int updated_at;
	private String url;
	private String checksum;
	
	public Game() {
		super();
	}
	public Game(int age_ratings, int category, int collection, int cover, int created_at, int external_games,
			int first_release_date, int franchises, int game_modes, int genres, int involved_companies, int keywords,
			String name, int platforms, int player_perspectives, int rating, int rating_count, int release_dates,
			int screenshots, int similar_games, String slug, String summary, int tags, int themes, int total_rating,
			int total_rating_count, int updated_at, String url, String checksum) {
		super();
		this.age_ratings = age_ratings;
		this.category = category;
		this.collection = collection;
		this.cover = cover;
		this.created_at = created_at;
		this.external_games = external_games;
		this.first_release_date = first_release_date;
		this.franchises = franchises;
		this.game_modes = game_modes;
		this.genres = genres;
		this.involved_companies = involved_companies;
		this.keywords = keywords;
		this.name = name;
		this.platforms = platforms;
		this.player_perspectives = player_perspectives;
		this.rating = rating;
		this.rating_count = rating_count;
		this.release_dates = release_dates;
		this.screenshots = screenshots;
		this.similar_games = similar_games;
		this.slug = slug;
		this.summary = summary;
		this.tags = tags;
		this.themes = themes;
		this.total_rating = total_rating;
		this.total_rating_count = total_rating_count;
		this.updated_at = updated_at;
		this.url = url;
		this.checksum = checksum;
	}
	@Id //For Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "age_ratings", nullable = false)
	public int getAge_ratings() {
		return age_ratings;
	}
	public void setAge_ratings(int age_ratings) {
		this.age_ratings = age_ratings;
	}
	@Column(name = "category", nullable = false)
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Column(name = "collection", nullable = false)
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}
	@Column(name = "cover", nullable = false)
	public int getCover() {
		return cover;
	}
	public void setCover(int cover) {
		this.cover = cover;
	}
	@Column(name = "created_at", nullable = false)
	public int getCreated_at() {
		return created_at;
	}
	public void setCreated_at(int created_at) {
		this.created_at = created_at;
	}
	@Column(name = "external_games", nullable = false)
	public int getExternal_games() {
		return external_games;
	}
	public void setExternal_games(int external_games) {
		this.external_games = external_games;
	}
	@Column(name = "first_release_date", nullable = false)
	public int getFirst_release_date() {
		return first_release_date;
	}
	public void setFirst_release_date(int first_release_date) {
		this.first_release_date = first_release_date;
	}
	@Column(name = "franchises", nullable = false)
	public int getFranchises() {
		return franchises;
	}
	public void setFranchises(int franchises) {
		this.franchises = franchises;
	}
	@Column(name = "game_modes", nullable = false)
	public int getGame_modes() {
		return game_modes;
	}
	public void setGame_modes(int game_modes) {
		this.game_modes = game_modes;
	}
	@Column(name = "genres", nullable = false)
	public int getGenres() {
		return genres;
	}
	public void setGenres(int genres) {
		this.genres = genres;
	}
	@Column(name = "involved_companies", nullable = false)
	public int getInvolved_companies() {
		return involved_companies;
	}
	public void setInvolved_companies(int involved_companies) {
		this.involved_companies = involved_companies;
	}
	@Column(name = "keywords", nullable = false)
	public int getKeywords() {
		return keywords;
	}
	public void setKeywords(int keywords) {
		this.keywords = keywords;
	}
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "platforms", nullable = false)
	public int getPlatforms() {
		return platforms;
	}
	public void setPlatforms(int platforms) {
		this.platforms = platforms;
	}
	@Column(name = "player_perspectives", nullable = false)
	public int getPlayer_perspectives() {
		return player_perspectives;
	}
	public void setPlayer_perspectives(int player_perspectives) {
		this.player_perspectives = player_perspectives;
	}
	@Column(name = "rating", nullable = false)
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Column(name = "rating_count", nullable = false)
	public int getRating_count() {
		return rating_count;
	}
	public void setRating_count(int rating_count) {
		this.rating_count = rating_count;
	}
	@Column(name = "release_dates", nullable = false)
	public int getRelease_dates() {
		return release_dates;
	}
	public void setRelease_dates(int release_dates) {
		this.release_dates = release_dates;
	}
	@Column(name = "screenshots", nullable = false)
	public int getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(int screenshots) {
		this.screenshots = screenshots;
	}
	@Column(name = "similar_games", nullable = false)
	public int getSimilar_games() {
		return similar_games;
	}
	public void setSimilar_games(int similar_games) {
		this.similar_games = similar_games;
	}
	@Column(name = "slug", nullable = false)
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	@Column(name = "summary", nullable = false)
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Column(name = "tags", nullable = false)
	public int getTags() {
		return tags;
	}
	public void setTags(int tags) {
		this.tags = tags;
	}
	@Column(name = "themes", nullable = false)
	public int getThemes() {
		return themes;
	}
	public void setThemes(int themes) {
		this.themes = themes;
	}
	@Column(name = "total_rating", nullable = false)
	public int getTotal_rating() {
		return total_rating;
	}
	public void setTotal_rating(int total_rating) {
		this.total_rating = total_rating;
	}
	@Column(name = "total_rating_count", nullable = false)
	public int getTotal_rating_count() {
		return total_rating_count;
	}
	public void setTotal_rating_count(int total_rating_count) {
		this.total_rating_count = total_rating_count;
	}
	@Column(name = "updated_at", nullable = false)
	public int getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(int updated_at) {
		this.updated_at = updated_at;
	}
	@Column(name = "url", nullable = false)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name = "checksum", nullable = false)
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", age_ratings=" + age_ratings + ", category=" + category + ", collection="
				+ collection + ", cover=" + cover + ", created_at=" + created_at + ", external_games=" + external_games
				+ ", first_release_date=" + first_release_date + ", franchises=" + franchises + ", game_modes="
				+ game_modes + ", genres=" + genres + ", involved_companies=" + involved_companies + ", keywords="
				+ keywords + ", name=" + name + ", platforms=" + platforms + ", player_perspectives="
				+ player_perspectives + ", rating=" + rating + ", rating_count=" + rating_count + ", release_dates="
				+ release_dates + ", screenshots=" + screenshots + ", similar_games=" + similar_games + ", slug=" + slug
				+ ", summary=" + summary + ", tags=" + tags + ", themes=" + themes + ", total_rating=" + total_rating
				+ ", total_rating_count=" + total_rating_count + ", updated_at=" + updated_at + ", url=" + url
				+ ", checksum=" + checksum + "]";
	}
}
