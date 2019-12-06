1- Tên ứng dụng: Ứng dụng đặt vé xem phim

2- Các chức năng chính:

 Đăng ký
 
 Đăng nhập

 Đặt vé

3- Cài đặt

JDK 8

Maven 3.6.0

Mysql 8.0.13

Cài Mysql trên Dockder:

Docker pull mysql:8.0.13

docker run -d -p 3308:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=cinema" mysql:8.0.13

docker start cinema

4- Những việc sẽ hoàn thiện trong thời gian tới

Các chức năng của admin như tạo phim, tạo lịch chiếu, ...