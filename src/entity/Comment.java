package entity;

public class Comment {

	private int commentId;
	private int postId;
	private int userId;
	private String dateCommented;
	private String contentCommented;
	
	public Comment(int commentId, int postId, int userId, String dateCommented, String contentCommented) {
		this.setCommentId(commentId);
		this.setPostId(postId);
		this.setUserId(userId);
		this.setDateCommented(dateCommented);
		this.setContentCommented(contentCommented);
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public String getDateCommented() {
		return dateCommented;
	}

	public void setDateCommented(String dateCommented) {
		this.dateCommented = dateCommented;
	}

	public String getContentCommented() {
		return contentCommented;
	}

	public void setContentCommented(String contentCommented) {
		this.contentCommented = contentCommented;
	}
	
	
}
