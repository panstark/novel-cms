-- 微信用户表
CREATE TABLE user_info_wx
(
	id varchar(64) NOT NULL COMMENT '主键',
	nick_name varchar(64) NOT NULL COMMENT '昵称',
	real_name varchar(64) NOT NULL COMMENT '真实名称',
	wx_id varchar(64)  COMMENT '微信id',
	avatar_url varchar(600) COMMENT '头像路径',
	gender char(1) DEFAULT '0' COMMENT '状态（0男 1女）',
	province varchar(64) NOT NULL COMMENT '省',
	city varchar(64)  COMMENT '市',
	county varchar(64) COMMENT '县',
	area varchar(64)  COMMENT '区',
	language varchar(64) DEFAULT 'zh_CN'	COMMENT '语言',
	status char(1) DEFAULT '0' NOT NULL COMMENT '状态（0正常 1删除 2停用）',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(500) COMMENT '备注信息',
	ext1 varchar(500) COMMENT '备用字段1',
	ext2 varchar(500) COMMENT '备用字段2',
	ext3 varchar(500) COMMENT '备用字段3',
	PRIMARY KEY (id)
) COMMENT = '微信用户表';

-- 短篇小说
CREATE TABLE novel_little
(
	id varchar(64) NOT NULL COMMENT '主键',
	number int DEFAULT 0 NOT NULL COMMENT '文章标号',
	like_num int DEFAULT 0 NOT NULL COMMENT '喜欢个数',
	type char(1) DEFAULT '0' NOT NULL COMMENT '小说类型',
	title varchar(100)  COMMENT '文章标题',
	title_two varchar(100)  COMMENT '文章副标题',
	author_id varchar(64)  COMMENT '作者id',
	author_name varchar(600)  COMMENT '作者名称',
	introduction varchar(600)  COMMENT '简介',
	mini_introduction varchar(100) COMMENT '精华',
	picture_url varchar(100)  COMMENT '图片链接',
	content text  COMMENT '文章内容',
	status char(1) DEFAULT '0' NOT NULL COMMENT '状态（0正常 1删除 2停用）',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(500) COMMENT '备注信息',
	ext1 varchar(500) COMMENT '备用字段1',
	ext2 varchar(500) COMMENT '备用字段2',
	ext3 varchar(500) COMMENT '备用字段3',
	PRIMARY KEY (id)
) COMMENT = '短篇小说';


-- 长篇小说
CREATE TABLE novel_info
(
	id varchar(64) NOT NULL COMMENT '主键',
	number int DEFAULT 0 NOT NULL COMMENT '文章标号',
	like_num int DEFAULT 100 COMMENT '喜欢个数',
	read_num int DEFAULT 100  COMMENT '阅读次数',
	author_id varchar(64)  COMMENT '作者id',
	author_name varchar(600)  COMMENT '作者名称',
	title varchar(100)  NOT NULL COMMENT '文章标题',
	title_two varchar(100)   COMMENT '文章副标题',
	type char(1) NOT NULL COMMENT '小说类型',
	introduction varchar(2000)  COMMENT '简介',
	mini_introduction varchar(500)  COMMENT '精华',
	picture_url varchar(300)  COMMENT '图片链接',
	music_url varchar(300)  COMMENT '图片链接',
	status char(1) DEFAULT '0' NOT NULL COMMENT '状态（0正常 1删除 2停用）',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(500) COMMENT '备注信息',
	ext1 varchar(500) COMMENT '备用字段1',
	ext2 varchar(500) COMMENT '备用字段2',
	ext3 varchar(500) COMMENT '备用字段3',
	PRIMARY KEY (id)
) COMMENT = '小说标题表';


-- 小说内容
CREATE TABLE novel_content
(
	id varchar(64) NOT NULL COMMENT '主键',
	novel_id varchar(64) NOT NULL COMMENT '关联主键',
	big_chapter	int DEFAULT 0 NOT NULL COMMENT '卷',
	big_chapter_str	varchar(30)  COMMENT '卷',
	chapter int DEFAULT 0 NOT NULL COMMENT '章',
	chapter_str	varchar(30)  COMMENT '卷',
	total_num int DEFAULT 0 COMMENT '总章数',
	title varchar(100)  NOT NULL COMMENT '文章标题',
	title_two varchar(100)  COMMENT '文章副标题',
	type char(1) DEFAULT '0' COMMENT '小说类型',
	content text  COMMENT '章节内容',
	mini_introduction varchar(500)  COMMENT '精华',
	picture_url varchar(300)  COMMENT '图片链接',
	status char(1) DEFAULT '0' NOT NULL COMMENT '状态（0正常 1删除 2停用）',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(500) COMMENT '备注信息',
	ext1 varchar(500) COMMENT '备用字段1',
	ext2 varchar(500) COMMENT '备用字段2',
	ext3 varchar(500) COMMENT '备用字段3',
	PRIMARY KEY (id)
) COMMENT = '小说内容表';


-- 读者阅读记录
CREATE TABLE user_read_log
(
	id varchar(64) NOT NULL COMMENT '主键',
	novel_id varchar(64) NOT NULL COMMENT '小说主键',
	wx_user_id varchar(64) NOT NULL COMMENT '读者id',
	last_read_chapter_id varchar(64)  COMMENT '上次阅读章节id',
	last_read_chapter_title varchar(100)  COMMENT '上次阅读章节标题',
	number int DEFAULT 0 NOT NULL COMMENT '文章标号',
	status char(1) DEFAULT '0' NOT NULL COMMENT '状态（0正常 1删除 2停用）',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(500) COMMENT '备注信息',
	ext1 varchar(500) COMMENT '备用字段1',
	ext2 varchar(500) COMMENT '备用字段2',
	ext3 varchar(500) COMMENT '备用字段3',
	PRIMARY KEY (id)
) COMMENT = '读者阅读记录';

CREATE TABLE novel_comment
(
	id varchar(64) NOT NULL COMMENT '主键',
	novel_id varchar(64) NOT NULL COMMENT '小说主键',
	wx_user_id varchar(64)  COMMENT '读者id',
	introduction varchar(500)  COMMENT '评论',
	title varchar(100)  COMMENT '文章标题',
	title_two varchar(100)  COMMENT '文章副标题',
	type char(1) NOT NULL COMMENT '评论类型',
	status char(1) DEFAULT '0' NOT NULL COMMENT '状态（0正常 1删除 2停用）',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(500) COMMENT '备注信息',
	ext1 varchar(500) COMMENT '备用字段1',
	ext2 varchar(500) COMMENT '备用字段2',
	ext3 varchar(500) COMMENT '备用字段3',
	PRIMARY KEY (id)
) COMMENT = '读者评论表';

CREATE TABLE novel_like
(
	id varchar(64) NOT NULL COMMENT '主键',
	novel_id varchar(64) NOT NULL COMMENT '小说主键',
	wx_user_id varchar(64)  COMMENT '读者id',
	like_num int  COMMENT '喜欢个数',
	status char(1) DEFAULT '0' NOT NULL COMMENT '状态（0正常 1删除 2停用）',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(500) COMMENT '备注信息',
	ext1 varchar(500) COMMENT '备用字段1',
	ext2 varchar(500) COMMENT '备用字段2',
	ext3 varchar(500) COMMENT '备用字段3',
	PRIMARY KEY (id)
) COMMENT = '读者喜欢个数表';