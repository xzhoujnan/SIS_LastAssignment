-- subjects
INSERT INTO subjects(subject_id, subject_code, subject_name, credit) VALUES (1, 'MATH101', 'Toán Cao Cấp', 3);
INSERT INTO subjects(subject_id, subject_code, subject_name, credit) VALUES (2, 'CS101', 'Lập Trình Cơ Bản', 3);
INSERT INTO subjects(subject_id, subject_code, subject_name, credit) VALUES (3, 'ENG101', 'Tiếng Anh Cơ Bản', 2);

-- students
INSERT INTO students(student_id, student_code, full_name, address) VALUES (1, 'SV001', 'Nguyen Van A', 'Hanoi');
INSERT INTO students(student_id, student_code, full_name, address) VALUES (2, 'SV002', 'Tran Thi B', 'Hanoi');
INSERT INTO students(student_id, student_code, full_name, address) VALUES (3, 'SV003', 'Le Van C', 'Hanoi');
INSERT INTO students(student_id, student_code, full_name, address) VALUES (4, 'SV004', 'Pham Thi D', 'Hanoi');
INSERT INTO students(student_id, student_code, full_name, address) VALUES (5, 'SV005', 'Do Van E', 'Hanoi');
INSERT INTO students(student_id, student_code, full_name, address) VALUES (6, 'SV006', 'Hoang Thi F', 'Hanoi');

-- scores (student_id, subject_id, score1, score2)
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (1, 1, 1, 7.0, 8.5);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (2, 2, 1, 8.0, 9.0);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (3, 3, 1, 6.0, 6.5);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (4, 4, 1, 5.0, 4.0);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (5, 5, 1, 9.0, 9.0);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (6, 6, 1, 3.0, 4.0);

INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (7, 1, 2, 6.5, 7.0);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (8, 2, 2, 7.0, 8.0);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (9, 3, 2, 8.0, 8.5);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (10, 4, 2, 4.0, 5.0);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (11, 5, 2, 9.0, 8.5);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (12, 6, 2, 2.0, 3.5);

INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (13, 1, 3, 8.0, 8.0);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (14, 2, 3, 6.0, 6.5);
INSERT INTO scores(id, student_id, subject_id, score1, score2) VALUES (15, 3, 3, 5.0, 5.0);
