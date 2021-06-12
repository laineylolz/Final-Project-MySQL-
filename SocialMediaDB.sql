Create database if not exists social_media;

Use social_media;

Drop table if exists comments;
Drop table if exists posts;
Drop table if exists user;

Create table user (
	id int(12) not null auto_increment, 
	username varchar(18) not null,
	first_name varchar(15) not null,
	last_name varchar(15) not null,
	birth_date date not null,
	email varchar(25) not null,
	password varchar(20) not null,
	primary key (id)
);

Create table posts (
	post_id int(12) not null auto_increment,
	user_id int(12) not null, 
	content_posted varchar(25) not null,
        date_posted date not null,
	Primary key(post_id),
	Foreign key (user_id) references user(id)
);

Create table comments(
	comment_id int(12) not null auto_increment,
	post_id int(12) not null,
	user_id int(12) not null,
	date_commented date not null,
	content_commented varchar(25) not null,
	Primary key (comment_id),
	Foreign key (post_id) references posts(post_id),
	Foreign key (user_id) references user(id)
);
