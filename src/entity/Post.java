package entity;

public class Post {

	private int postId;
	private int userId;
	private String datePosted;
	private String contentPosted;
	
	public Post(int postId, int userId, String datePosted, String contentPosted) {
		this.setPostId(postId);
		this.setUserId(userId);
		this.setDatePosted(datePosted);
		this.setContentPosted(contentPosted);
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}

	public String getContentPosted() {
		return contentPosted;
	}

	public void setContentPosted(String contentPosted) {
		this.contentPosted = contentPosted;
	}
	
	
}
