package application;



import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CommentDao;
import dao.PostDao;
import dao.UserDao;
import entity.Comment;
import entity.Post;
import entity.User;

public class Menu {
	
	private UserDao userDao = new UserDao();
	private PostDao postDao = new PostDao();
	private CommentDao commentDao = new CommentDao();
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Create a User",
			"Display A User",
			"Update a User",
			"Delete a User", 
			"Create a Post",
			"Display a Post",
			"Edit a Post",
			"Delete a Post",
			"Create a Comment",
			"Display a Comment",
			"Edit a Comment",
			"Delete a Comment");
	
	
	public void start() {
		String selection = "";
		
		do {
			
			printMenu();
			selection = scanner.nextLine();
			
			try {
			if (selection.equals("1")) {
				createUser();
			}
			else if (selection.equals("2")) {
				displayUser();
			}
			else if (selection.equals("3")) {
				updateUser();
			}
			else if (selection.equals("4")) {
				deleteUser();	
			}
			else if (selection.equals("5")) {
				createPost();
			}
			else if (selection.equals("6")) {
				displayPost();
			}
			else if (selection.equals("7")) {
				updatePost();
			}
			else if (selection.equals("8")) {
				deletePostById();
			}
			else if (selection.equals("9")) {
				createComment();
			}
			else if (selection.equals("10")) {
				displayComment();
			}
			else if (selection.equals("11")) {
				updateComment();
			}
			else if (selection.equals("12")) {
				deleteComment();
			}
			
			}catch (SQLException e) {
            	e.printStackTrace();
            }
			
			
			System.out.println("Press enter to continue.....");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Please Select An Option: \n ----------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	///USER METHODS***********************************************************
	
	private void createUser() throws SQLException {
		System.out.println("Enter New User Username: ");
		String username = scanner.nextLine();
		System.out.println("Enter New User First Name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter New User Last Name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter New User Birth Date (YYYY-MM-DD): ");
		String birthDate = scanner.nextLine();
		System.out.println("Enter New User Email: ");
		String email = scanner.nextLine();
		System.out.println("Enter New User Password: ");
		String password = scanner.nextLine();
		userDao.createNewUser(username, firstName, lastName, birthDate, email, password);
	}
	
	private void displayUser() throws SQLException {
		System.out.println("Enter User ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		User user = userDao.getUserById(id);
		System.out.println("User ID: " + user.getUserId() + "\n Username: " + user.getUserUsername() +
				"\n First Name: " + user.getUserFirstName() + "\n Last Name: " + user.getUserLastName() +
				"\n Birth Date: " + user.getUserBirthDate());
	}
	
	private void updateUser() throws SQLException {
		System.out.println("Update User: ");
		
		User user = getUserById();
		
		printUser(user);
		System.out.println("Select What You Want to Update: ");
		System.out.println("1) Username: ");
		System.out.println("2) First Name: ");
		System.out.println("3) Last Name: ");
		System.out.println("4) Email: ");
		System.out.println("5) Password: ");
		System.out.println("6) Press 6 to Cancel: ");
		
		int selection = Integer.parseInt(scanner.nextLine());
		
		switch (selection) {
		case 1: setUsername(user);
			break;
		case 2: setFirstName(user);
			break;
		case 3: setLastName(user);
			break;
		case 4: setEmail(user);
			break;
		case 5: setPassword(user);
			break;
		default:
			System.out.println("Cancelling update...\n");
			break;
		}
		
	}
	private User getUserById() throws SQLException {
		System.out.println("Please Enter User ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		return userDao.getUserById(id);
	}
	private void printUser(User user) {
		System.out.println("User: " + user.getUserUsername());
	}
	private void setUsername(User user) throws SQLException {
		System.out.println("Enter the new Username: ");
		user.setUserUsername(scanner.nextLine());
		userDao.updateUser(user);
	}
	private void setFirstName(User user) throws SQLException {
		System.out.println("Enter updated First Name: ");
		user.setUserFirstName(scanner.nextLine());
		userDao.updateUser(user);
	}
	private void setLastName(User user) throws SQLException {
		System.out.println("Enter updated Last Name: ");
		user.setUserLastName(scanner.nextLine());
		userDao.updateUser(user);
	}
	private void setEmail(User user) throws SQLException {
		System.out.println("Enter updated Email: ");
		user.setUserEmail(scanner.nextLine());
		userDao.updateUser(user);
	}
	private void setPassword (User user) throws SQLException {
		System.out.println("Enter new Password: ");
		user.setUserPassword(scanner.nextLine());
		userDao.updateUser(user);
	}
	private void deleteUser() throws SQLException {
		System.out.println("Enter User Id You Want to Delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		userDao.deleteUserById(id);
	}
	
	////POST METHODS***********************************************
	
	private void createPost() throws SQLException {
		System.out.println("Enter User ID: ");
		int userId = scanner.nextInt();
		System.out.println("New Post: ");
		String content = scanner.nextLine();
		postDao.createNewPost(userId, content);
		
	}
	private void displayPost() throws SQLException {
		System.out.println("Enter Post ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Post post = postDao.getPostById(id);
		System.out.println(post.getPostId() + " - " + post.getDatePosted() + " - " + post.getContentPosted());
		
	}
	private void deletePostById() throws SQLException {
	System.out.println("Enter Post Id You Want to Delete: ");
	int id = Integer.parseInt(scanner.nextLine());
	postDao.deletePostById(id);
	}
	private void updatePost() throws SQLException {
	System.out.println("Edit Post: ");
	
	Post post = getPostById();
	
	printPost(post);
	System.out.println("Would You Like to Edit This Post?");
	System.out.println("Press 1 For Yes \n Press 2 for No");
	
	
	int selection = Integer.parseInt(scanner.nextLine());
	
	switch (selection) {
	case 1: setContent(post);
		break;
	default:
		System.out.println("Cancelling update...\n");
		break;
		}
	}
	private Post getPostById() throws SQLException {
		System.out.println("Please Enter Post ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		return postDao.getPostById(id);
	}
	private void printPost(Post post) {
		System.out.println("Post:  " + post.getPostId() + ": " + post.getContentPosted());
	}
	private void setContent(Post post) throws SQLException {
		System.out.println("Enter Edited Post: ");
		post.setContentPosted(scanner.nextLine());
		postDao.updatePost(post);
	}
	
	////COMMENT METHODS *************************************
	
	private void createComment() throws SQLException {
		System.out.println("Enter PostID: ");
		int postId = scanner.nextInt();
		System.out.println("Enter UserID: ");
		int userId = scanner.nextInt();
		System.out.println("Enter Comment: ");
		String content = scanner.nextLine();
		commentDao.createNewComment(postId, userId, content);
	}
	private void displayComment() throws SQLException {
		System.out.println("Enter Comment ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Comment comment = commentDao.getCommentById(id);
		System.out.println(comment.getCommentId() + ": " + comment.getContentCommented());
	}
	
	private void updateComment() throws SQLException {
		System.out.println("Edit Comment: ");
		
		Comment comment = getCommentById();
		
		printComment(comment);
		System.out.println("Would You Like to Edit This Comment?");
		System.out.println("Press 1 For Yes \n Press 2 for No");
		
		
		int selection = Integer.parseInt(scanner.nextLine());
		
		switch (selection) {
		case 1: setContent(comment);
			break;
		default:
			System.out.println("Cancelling update...\n");
			break;
			}
		}
		private Comment getCommentById() throws SQLException {
			System.out.println("Please Enter Comment ID: ");
			int id = Integer.parseInt(scanner.nextLine());
			return commentDao.getCommentById(id);
		}
		private void printComment(Comment comment) {
			System.out.println("Comment:  " + comment.getCommentId() + ": " + comment.getContentCommented());
		}
		private void setContent(Comment comment) throws SQLException {
			System.out.println("Enter Edited Comment: ");
			comment.setContentCommented(scanner.nextLine());
			commentDao.updateComment(comment);
		}
		private void deleteComment() throws SQLException {
			System.out.println("Enter Comment Id You Want to Delete: ");
			int id = Integer.parseInt(scanner.nextLine());
			commentDao.deleteCommentById(id);
		}
}

