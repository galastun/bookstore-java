USE library;

SET AUTOCOMMIT=0;
INSERT INTO books VALUES
(1, "The Hobbit", "9780547928227", 320, 1, 1, 1),
(2, "The Fellowship of the Ring", "9780547928210", 432, 1, 1, 1),
(3, "The Two Towers", "9780547928203", 352, 1, 1, 1),
(4, "The Return of the King", "9780547928197", 432, 1, 1, 1),
(5, "If You Give a Mouse a Cookie", "9780547928197", 32, 2, 2, 2),
(6, "If You Give a Pig a Pancake", "9780064436632", 32, 2, 2, 2),
(7, "If You Give a Moose a Muffin", "9780064433662", 32, 2, 2, 2),
(8, "If You Give a Cat a Cupcake", "9780060283247", 32, 2, 2, 2),
(9, "If You Give a Dog a Donut", "9780060266837", 32, 2, 2, 2),
(10, "The Silmarillion", "9780808521402", 442, 1, 1, 3);
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO categories VALUES
(1, "Fantasy"),
(2, "Childrens");
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO authors VALUES
(1, "J.R.R.", "Tolkien"),
(2, "Laura", "Numeroff");
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO publishers VALUES
(1, "Houghton Mifflin Harcourt"),
(2, "HarperCollins Publishers"),
(3, "Turtleback Books");
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO libraries VALUES
(1, "Tolkien Territory"),
(2, "If You Give a Kid a Book");
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO book_collection VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 5),
(6, 2, 6),
(7, 2, 7),
(8, 2, 8),
(9, 2, 9),
(10, 1, 10);
COMMIT;
