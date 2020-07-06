insert into job(job_title, department) 
values ('Java Developer', 'Development');

insert into job(job_title, department)
values ('Tester', 'Testing');

insert into user(EMAIL, FIRST_NAME, LAST_NAME, POSITION, ROLE, STATUS, JOB_ID) 
values('nikkumar334@gmail.com', 'Nikhil', 'Kumar', 'admin', 'Developer', true, null);

insert into user(EMAIL, FIRST_NAME, LAST_NAME, POSITION, ROLE, STATUS, JOB_ID) 
values('amanb@gmail.com', 'Aman', 'Bhardwaj', 'candidate', 'Developer', true, 1);

insert into user(EMAIL, FIRST_NAME, LAST_NAME, POSITION, ROLE, STATUS, JOB_ID) 
values('bipul@gmail.com', 'Bipul', 'Kumar', 'visitor', 'Tester', true, 1);

insert into user_login(user_Id, password) 
values (1, '1234');

insert into user_login(user_Id, password) 
values (3, '4567');