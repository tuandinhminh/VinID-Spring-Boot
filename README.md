## 1 - Tên ứng dụng:
 Ứng dụng đặt vé xem phim
## 2 - Các chức năng chính: 
 - Đăng ký 
 - Đăng nhập
 - Đặt vé
## 3 - Cài đặt
 - JDK 8
 - Maven 3.6.0
 - Mysql 8.0.13
### Cài Mysql trên Docker:
  + Docker pull mysql:8.0.13
  + docker run -d -p 3308:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=cinema" mysql:8.0.13
  + docker start cinema 
### Database
https://imgur.com/a/FEWbsGY
## 4 - Các việc cần hoàn thiện
 - Các chức năng của admin
