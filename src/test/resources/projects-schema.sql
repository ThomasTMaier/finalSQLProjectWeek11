DROP TABLE IF EXISTS project_category;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS step;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS project;

CREATE TABLE project(
	project_id int auto_increment NOT NULL /*AUto_INCREMENT*/ PRIMARY KEY,
    project_name varchar (128),
    estimated_hours DOUBLE,
    actual_hours DOUBLE,
    difficulty INT,
    notes TEXT

);
CREATE TABLE material(
	material_id int auto_increment  NOT NULL /*AUTO_INCREMENT*/ PRIMARY KEY,
    project_id int  NOT NULL /*AUTO_INCREMENT*/, 
    material_name varchar (64),
    num_required int NOT NULL,
    cost DOUBLE NOT null,
    foreign key  (project_id) references project (project_id) on delete cascade 
   
    
);
CREATE TABLE step(
	step_id int auto_increment NOT NULL /*AUTO_INCREMENT*/ PRIMARY KEY,
    project_id int  NOT NULL /*AUTO_INCREMENT*/, 
    step_text TEXT NOT null,
	foreign key  (project_id) references project (project_id) on delete cascade 
    

);

CREATE TABLE category(
	category_id int auto_increment NOT NULL /*AUTO_INCREMENT*/ PRIMARY KEY,
    category_name varchar(64) NOT NULL
); 
CREATE TABLE project_category(
	project_id int   NOT NULL /*AUTO_INCREMENT*/,
    category_id int  NOT NULL /*AUTO_INCREMENT*/,
    foreign key  (project_id) references project (project_id) on delete cascade, 
    foreign key  (category_id) references category (category_id) on delete cascade 
 
);