create schema QA_2_Practic;

create table "qa_2_practic".Flight(
                                      id serial not null unique ,
                                      airplane_model varchar(20) not null ,
                                      departure_time timestamp not null ,
                                      departure_place int references Airports(code_of_the_airport),
                                      place_of_arrival int references Airports(code_of_the_airport),
                                      flight_duration time not null ,
                                      number_of_seats int not null ,
                                      flight_number int not null,
                                      PRIMARY KEY (flight_number)
);
create table "qa_2_practic".Countries(
                                         id serial not null unique ,
                                         code_of_the_country int not null unique ,
                                         name_of_country varchar(100),
                                         PRIMARY KEY (code_of_the_country)
);
create table "qa_2_practic".Airports(
                                        id serial not null unique ,
                                        code_of_the_airport int not null unique ,
                                        code_of_the_city int not null ,
                                        code_of_the_country int references Countries(code_of_the_country),
                                        PRIMARY KEY(code_of_the_airport)
);
create table "qa_2_practic".Clients(
                                       id serial not null unique ,
                                       identification_number int not null unique ,
                                       id_passport int not null unique ,
                                       full_name varchar not null ,
                                       gender varchar(10) not null ,
                                       country int references Countries(code_of_the_country),
                                       PRIMARY KEY (id_passport)
);
create table "qa_2_practic".Tickets(
                                       id_clients int references Clients(id_passport),
                                       flight_number int references Flight(flight_number),
                                       receiving_time time not null ,
                                       number_of_ticket serial not null unique
);
-- Рейсов, которые должны содержать информацию о модели самолета, времени вылета, откуда вылет(код аэропорта), где будет прилет(код аэропорта), длительности полета, количество мести номер рейса(2б)
-- Стран, которые будут содержать код страны и ее наименование(1б)
-- Аэропортов, которые будут содержать код аэропорта, город в котором находится и код страны(1б)
-- Клиентов, которые должны содержать информацию по типу паспортных данных (инн, айди паспорта, ФИО, пол, страна и тд)(1б)
-- Билетов, которые будут содержать в себе айди клиента, номер рейса, время получения билетаи номер билета(2б)
