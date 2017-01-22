create table datatemp(
    data_id INT NOT NULL AUTO_INCREMENT,
    temperature LONG NOT NULL,
    humidity LONG NOT NULL,
    date_time TIMESTAMP NOT NULL,
    local_date_time VARCHAR(20) NOT NULL
    PRIMARY KEY (data_id)
);