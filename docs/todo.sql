DROP TABLE todo
CREATE TABLE todo
(
id INT(11) PRIMARY KEY auto_increment,
`name` VARCHAR(50),
detail VARCHAR(1000),
created_at datetime,
finished_at datetime,
state VARCHAR(20),todo
memo VARCHAR(200)
);
INSERT todo VALUES(0,'李子奇','打太极','2018-11-13','2018-12-12','已完成','暂无');
INSERT todo VALUES(0,'吴麒麟','盗墓','2018-09-10','2018-12-21','已完成','暂无');
INSERT todo VALUES(0,'马甸','写作业','2018-12-02','2018-12-08','已完成','暂无');
INSERT todo VALUES(0,'风清扬','拍广告','2018-11-10','2019-12-12','已完成','暂无');