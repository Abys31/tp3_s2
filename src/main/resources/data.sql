-- Initialisation des tables
-- Ce fichier ne peut pas être vide
insert into projet(code, nom, debut, fin) values (10248, 'ISIs' , '1995-02-2022', null);
insert into projet(code, nom, debut, fin) values (10249, 'IUT' , '1995-02-2022','41996-06-12');

insert into Personne (matricule, nom, Prenom, poste)value (48, 'yasso', 'bela', 'leboss');

insert into Participation(id,contributeur_matricule, affectation_code, pourcentage, role)value (81, 48 ,10248 ,25,null );