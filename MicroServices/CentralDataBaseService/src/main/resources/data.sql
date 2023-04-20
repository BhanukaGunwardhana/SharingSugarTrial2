insert into status values (1,"active");
insert into status values (2,"inactive");
insert into status values (3,"accepted");
insert into status values (4,"rejected");
insert into status values (5,"pending");

/*select * from category;*/
insert into category values (1,"vehicles");
insert into category values (2,"properties");
insert into category values (3,"equipments");
insert into category values (4,"services");

/*select * from subcategory;*/
insert into subcategory values(1,"bus",1,1);
insert into subcategory values(2,"car",1,1);
insert into subcategory values(3,"van",1,1);
insert into subcategory values(4,"other",1,1);

insert into subcategory values(5,"house",2,1);
insert into subcategory values(6,"lands",2,1);

insert into subcategory values(7,"bed",3,1);
insert into subcategory values(8,"grasscutter",3,1);
insert into subcategory values(9,"ACmachine",3,1);
insert into subcategory values(10,"LapTop",3,1);

insert into subcategory values(11,"clothes",4,1);
insert into subcategory values(12,"shoes",4,1);

/*select * from location;*/
insert into location values(1,"Baltimore",1);

insert into sugarposttype values(1,"wantsugar");
insert into sugarposttype values(2,"sharesugar");