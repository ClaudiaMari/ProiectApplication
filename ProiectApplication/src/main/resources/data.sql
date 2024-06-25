-- Crearea tabelelor (dacă nu există deja)
CREATE TABLE IF NOT EXISTS autor (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     nume VARCHAR(255) NOT NULL,
                                     prenume VARCHAR(255) NOT NULL,
                                     data_nasterii DATE
);

CREATE TABLE IF NOT EXISTS editura (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nume VARCHAR(255) NOT NULL,
                                       adresa VARCHAR(255),
                                       telefon VARCHAR(20)
);

-- Creare tabel categorie (cu IF NOT EXISTS)
CREATE TABLE IF NOT EXISTS categorie (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         nume VARCHAR(100) NOT NULL
);

-- Creare tabel carte (cu IF NOT EXISTS)
CREATE TABLE IF NOT EXISTS carte (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     titlu VARCHAR(255) NOT NULL,
                                     autor_id INT NOT NULL,
                                     editura_id INT NOT NULL,
                                     FOREIGN KEY (autor_id) REFERENCES autor(id),
                                     FOREIGN KEY (editura_id) REFERENCES editura(id)
);

-- Creare tabel carte_categorie (cu IF NOT EXISTS)
CREATE TABLE IF NOT EXISTS carte_categorie (
                                               carte_id INT NOT NULL,
                                               categorie_id INT NOT NULL,
                                               PRIMARY KEY (carte_id, categorie_id),
                                               FOREIGN KEY (carte_id) REFERENCES carte(id),
                                               FOREIGN KEY (categorie_id) REFERENCES categorie(id)
);

-- Creare tabel utilizator (cu IF NOT EXISTS)
CREATE TABLE IF NOT EXISTS utilizator (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          username VARCHAR(50) NOT NULL,
                                          password VARCHAR(255) NOT NULL,
                                          email VARCHAR(100) NOT NULL,
                                          rol ENUM('ADMIN', 'USER') NOT NULL
);

-- Creare tabel recenzie (cu IF NOT EXISTS)
CREATE TABLE IF NOT EXISTS recenzie (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        carte_id INT NOT NULL,
                                        utilizator_id INT NOT NULL,
                                        text TEXT NOT NULL,
                                        rating INT NOT NULL,
                                        data_publicarii DATETIME NOT NULL,
                                        FOREIGN KEY (carte_id) REFERENCES carte(id),
                                        FOREIGN KEY (utilizator_id) REFERENCES utilizator(id)
);

-- Inserare autori
INSERT INTO autor (nume, prenume, data_nasterii) VALUES
                                                     ('Eminescu', 'Mihai', '1850-01-15'),
                                                     ('Caragiale', 'Ion Luca', '1852-02-13'),
                                                     ('Creangă', 'Ion', '1837-03-01');

-- Inserare edituri
INSERT INTO editura (nume, adresa, telefon) VALUES
                                                ('Humanitas', 'Bucuresti, Str. Principală 1', '021123456'),
                                                ('Polirom', 'Iași, Str. Secundară 2', '0232654321');

-- Inserare categorii
INSERT INTO categorie (nume) VALUES
                                 ('Poezie'),
                                 ('Proză'),
                                 ('Dramă');

-- Inserare cărți
INSERT INTO carte (titlu, autor_id, editura_id) VALUES
                                                    ('Luceafărul', 1, 1),
                                                    ('O scrisoare pierdută', 2, 2),
                                                    ('Amintiri din copilărie', 3, 1);

-- Inserare asocieri carte-categorie
INSERT INTO carte_categorie (carte_id, categorie_id) VALUES
                                                         (1, 1), -- Luceafărul - Poezie
                                                         (2, 3), -- O scrisoare pierdută - Dramă
                                                         (3, 2); -- Amintiri din copilărie - Proză

-- Inserare utilizatori
INSERT INTO utilizator (username, password, email, rol) VALUES
                                                            ('admin', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbPLSm', 'admin@example.com', 'ADMIN'),
                                                            ('user', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbPLSm', 'user@example.com', 'USER');

-- Inserare recenzii
INSERT INTO recenzie (carte_id, utilizator_id, text, rating, data_publicarii) VALUES
                                                                                  (1, 2, 'O capodoperă a literaturii române!', 5, '2023-01-15 10:30:00'),
                                                                                  (2, 2, 'Comedie excelentă, foarte amuzantă.', 4, '2023-02-20 14:45:00'),
                                                                                  (3, 1, 'O lectură plăcută și nostalgică.', 5, '2023-03-10 09:15:00');