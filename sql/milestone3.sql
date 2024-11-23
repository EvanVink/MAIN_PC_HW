CREATE TABLE Player (
    player_id INTEGER NOT NULL,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    PRIMARY KEY (player_id)
);

SELECT * FROM Player;

INSERT INTO Player
VALUES
    (1, 'PlayerOne', 'password123'),
    (2, 'PlayerTwo', 'securePass456'),
    (3, 'PlayerThree', 'ProPass789'),
    (4, 'PlayerFour', 'easyWin321'),
    (5, 'PlayerFive', 'fastPass654');

CREATE TABLE Friend (
    player_id INTEGER NOT NULL,
    friend_id INTEGER NOT NULL,
    PRIMARY KEY (player_id, friend_id),
    FOREIGN KEY (friend_id) REFERENCES Player(player_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

SELECT  * FROM Friend;

INSERT INTO Friend (player_id, friend_id)
VALUES
    (1, 2),
    (1, 12),
    (12, 4),
    (3, 5),
    (10, 1);


CREATE TABLE Game (
    game_id INTEGER NOT NULL,
    title VARCHAR(50) NOT NULL,
    company_id INTEGER NOT NULL,
    release_date INTEGER DEFAULT NULL,
    price_cad INTEGER DEFAULT 0,
    PRIMARY KEY (game_id),
    FOREIGN KEY (company_id) REFERENCES Company(company_id)
);

CREATE TABLE Characters (
    character_id INTEGER NOT NULL,
    weapon_id INTEGER DEFAULT NULL,
    gear_id INTEGER DEFAULT NULL,
    item_id INTEGER DEFAULT NULL,
    kills INTEGER DEFAULT 0,
    deaths INTEGER DEFAULT 0,
    stats INTEGER DEFAULT 0,
    PRIMARY KEY (character_id),
    FOREIGN KEY (weapon_id) REFERENCES Weapon(weapon_id),
    FOREIGN KEY (gear_id) REFERENCES Gear(gear_id),
    FOREIGN KEY (item_id) REFERENCES Item(item_id)
);

SELECT * FROM Weapon;

INSERT INTO Characters (character_id, weapon_id, gear_id, item_id, kills, deaths, stats)
VALUES
    (6, 3, 1, 1, 10, 5, 50), 
    (2, 23, 2, 2, 25, 8, 100), 
    (3, 57, 3, 3, 30, 10, 120),
    (4, 75, 4, 4, 5, 2, 30), 
    (5, 101, 5, 5, 15, 7, 75);

SELECT * FROM characters;

INSERT INTO Characters
VALUES (1, 3, 1, 1, 3, 1, 14);



CREATE TABLE Map (
    map_id INTEGER NOT NULL,
    map_name VARCHAR(50) NOT NULL,
    map_size INTEGER DEFAULT 0,
    PRIMARY KEY (map_id)
);

INSERT INTO Map (map_id, map_name, map_size)
VALUES
    (4, 'Bank', 5000),
    (2, 'Clubhouse', 4500),
    (3, 'Consulate', 4800),
    (5, 'Chalet', 4700);


SELECT * FROM Map;

CREATE TABLE Leaderboard (
    position INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    score INTEGER DEFAULT 0,
    PRIMARY KEY (position, player_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

SELECT * FROM Leaderboard;

INSERT INTO Leaderboard (position, player_id, score)
VALUES
    (1, 3, 1500), 
    (2, 2, 1400), 
    (3, 1, 1300), 
    (4, 5, 1200), 
    (5, 4, 1100);


CREATE TABLE Mission (
    mission_id INTEGER NOT NULL,
    completed BOOLEAN DEFAULT FALSE,
    mission_description CHAR(100) NOT NULL,
    reward VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (mission_id)
);

INSERT INTO Mission (mission_id, completed, mission_description, reward)
VALUES
    (6, FALSE, 'Disarm the bomb in the enemy compound', '500 XP'),
    (2, TRUE, 'Rescue the hostage and extract safely', 'Legendary Skin'),
    (3, FALSE, 'Secure the biohazard container', '1000 XP'),
    (4, TRUE, 'Defend the objective for 5 minutes', 'Rare Gear'),
    (5, FALSE, 'Eliminate all enemy targets', 'Epic Weapon Blueprint');
    
SELECT * FROM mission;



CREATE TABLE Weapon (
    weapon_id INTEGER NOT NULL,
    weapon_name CHAR(30) NOT NULL,
    weapon_description VARCHAR(200),
    weapon_type CHAR(30) NOT NULL,
    rarity CHAR(30) NOT NULL,
    damage FLOAT DEFAULT 0,
    kills INTEGER DEFAULT 0,
    PRIMARY KEY (weapon_id)
);

SELECT avg(damage)
FROM Weapon
WHERE rarity = 'Legendary';


SELECT * FROM Weapon;

CREATE TABLE Gear (
    gear_id INTEGER NOT NULL,
    gear_type CHAR(30) NOT NULL,
    rarity CHAR(30) NOT NULL,
    bonus_health INTEGER DEFAULT 0,
    bonus_armour INTEGER DEFAULT 0,
    PRIMARY KEY (gear_id)
);

INSERT INTO Gear (gear_id, gear_type, rarity, bonus_health, bonus_armour)
VALUES
    (2, 'Helmet', 'Epic', 50, 20),
    (3, 'Boots', 'Rare', 30, 10),
    (4, 'Gloves', 'Common', 10, 5),
    (5, 'Shield', 'Epic', 0, 70);

INSERT INTO Gear (gear_id, gear_type, rarity, bonus_health, bonus_armour)
VALUES (1, 'Chestplate', 'Legendary', 200, 150);


SELECT * FROM Gear;

CREATE TABLE Item (
    item_id INTEGER NOT NULL,
    item_type CHAR(30) NOT NULL,
    price FLOAT DEFAULT 0,
    rarity CHAR(30) DEFAULT NULL,
    PRIMARY KEY (item_id)
);

INSERT INTO Item (item_id, item_description, item_type, price, rarity)
VALUES
    (2, 'Grants immunity for 10 seconds', 'Elixir', 100.0, 'Rare'),
    (3, 'Restores 100 Hunger points', 'Cheese', 500.0, 'Epic'),
    (4, 'Teleports back home', 'TP Potion', 450.0, 'Legendary'),
    (5, 'A standard arrow for bows', 'Arrow', 5.0, 'Common');

SELECT * FROM Item;

INSERT INTO Item
VALUES (1, 'Restores 50 health points when consumed.', 'Health Potion', 20.0, 'Rare');


CREATE TABLE Purchases (
    player_id INTEGER NOT NULL,
    username VARCHAR(30) NOT NULL,
    game_id INTEGER NOT NULL,
    company_id INTEGER NOT NULL,
    date_owned VARCHAR(11) DEFAULT NULL,
    hours_played INTEGER DEFAULT 0,
    PRIMARY KEY (player_id, game_id, company_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id),
    FOREIGN KEY (game_id) REFERENCES Game(game_id),
    FOREIGN KEY (company_id) REFERENCES Company(company_id),
    FOREIGN KEY (username) REFERENCES Player(username)
);

INSERT INTO Purchases (player_id, username, game_id, company_id, date_owned, hours_played)
VALUES
    (1, 'PlayerOne', 9, 66, 'Jan-1-2024', 25),
    (2, 'PlayerTwo', 1, 99, 'Feb-20-2016', 40),
    (3, 'PlayerThree', 3, 77, 'Mar-15-2023', 15),
    (4, 'PlayerFour', 5, 88, 'Apr-3-2022', 60),
    (5, 'PlayerFive', 1, 99, 'May-12-2021', 10);
    
SELECT * FROM Company;

SELECT * FROM Game;
    
SELECT * FROM Purchases;

CREATE TABLE PlatformOwns (
    platform_id INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    PRIMARY KEY (platform_id, player_id),
    FOREIGN KEY (platform_id) REFERENCES Platform(platform_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

INSERT INTO Platformowns
VALUES (1, 1),
(2, 2), 
(3, 3),
(4, 4),
(5, 5);

SELECT * FROM platformowns;


CREATE TABLE Possesses (
    weapon_id INTEGER NOT NULL,
    gear_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    amount_owned INTEGER DEFAULT 1,
    character_id INTEGER NOT NULL,
    equipped BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (weapon_id, gear_id, item_id),
    FOREIGN KEY (weapon_id) REFERENCES Weapon(weapon_id),
    FOREIGN KEY (gear_id) REFERENCES Gear(gear_id),
    FOREIGN KEY (item_id) REFERENCES Item(item_id)
);

SELECT * FROM Weapon;

INSERT INTO Possesses (weapon_id, gear_id, item_id, amount_owned, character_id, equipped)
VALUES
    (3, 1, 1, 3, 1, TRUE), 
    (23, 2, 2, 1, 2, FALSE),
    (57, 3, 3, 5, 3, TRUE),
    (75, 4, 4, 2, 4, FALSE), 
    (101, 5, 5, 10, 5, TRUE);

SELECT * FROM Possesses;

CREATE TABLE Ranks_on (
    player_id INTEGER NOT NULL,
    rank_position INTEGER NOT NULL,
    PRIMARY KEY (player_id, rank_position),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

INSERT INTO Ranks_on (player_id, rank_position)
VALUES
    (1, 1), 
    (2, 2), 
    (3, 3), 
    (4, 4), 
    (5, 5);


SELECT * FROM Ranks_on;


CREATE TABLE Achievements (
	achievement_id INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    achievement_description VARCHAR(200) NOT NULL,
    date_achieved VARCHAR(11),
    PRIMARY KEY (achievement_id, player_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

SELECT * FROM Achievements;

INSERT INTO Achievements (achievement_id, player_id, achievement_description, date_achieved)
VALUES
    (2, 12, 'Reached level 50', 'Feb-10-2022'),
    (3, 3, 'Defeated 1000 enemies', 'Jul-29-2023'),
    (4, 10, 'Unlocked the legendary weapon', 'Dec-1-2021'),
    (5, 5, 'Completed all side quests', 'Oct-4-2020');



INSERT INTO Achievements
VALUES (1, 12, 'killed ten enemies', 'Nov-18-2024');

CREATE TABLE Achieves (
    player_id INTEGER NOT NULL,
    achievement_id INTEGER NOT NULL,
    date_earned VARCHAR(11) DEFAULT NULL,
    PRIMARY KEY (player_id, achievement_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id),
    FOREIGN KEY (achievement_id) REFERENCES Achievements(achievement_id)
);

CREATE TABLE Incorporates (
    map_id INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    character_id INTEGER NOT NULL,
    position INTEGER NOT NULL,
    achievement_id INTEGER NOT NULL,
    mission_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    genre CHAR(30) NOT NULL,
    data_size FLOAT DEFAULT 0,
    PRIMARY KEY (map_id, character_id, player_id, position, achievement_id, mission_id),
    FOREIGN KEY (map_id) REFERENCES Map(map_id),
    FOREIGN KEY (character_id) REFERENCES Characters(character_id),
    FOREIGN KEY (position, player_id) REFERENCES Leaderboard(position, player_id),
    FOREIGN KEY (achievement_id, player_id) REFERENCES Achievements(achievement_id, player_id),
    FOREIGN KEY (mission_id) REFERENCES Mission(mission_id),
    FOREIGN KEY (game_id) REFERENCES Game(game_id)
);

INSERT INTO Incorporates (map_id, player_id, character_id, position, achievement_id, mission_id, game_id, genre, data_size)
VALUES
    (2, 12, 2, 1, 2, 2, 9, 'Action', 12.0), 
    (3, 3, 3, 1, 3, 3, 10, 'Strategy', 18.3), 
    (5, 5, 5, 4, 5, 5, 5, 'Adventure', 10.5);
    
SELECT * FROM achievements;

SELECT * FROM Game;

SELECT * FROM Incorporates;

SELECT * FROM Leaderboard;

    
    
SELECT mission_id
FROM Mission
WHERE mission_id IN (
	SELECT mission_id
    FROM Incorporates
    WHERE player_id = (
		SELECT friend_id
        FROM Friend
        WHERE player_id = 10 AND friend_id = 12
	) AND completed = TRUE
);

SELECT * FROM Friend;

SELECT kills / deaths
FROM Characters
WHERE character_id = (
	SELECT character_id
    FROM Incorporates
    WHERE map_id = 1 AND character_id = 1
);

INSERT INTO Incorporates
VALUES (1, 12, 1, 1, 1, 1, 1, 'Shooter', 66.7);

SELECT achievement_id
FROM Achievements
Where player_id = (
	SELECT player_id
	FROM Incorporates
    WHERE player_id = 12
);


SELECT * FROM Player;
SELECT * FROM Characters;
SELECT * FROM Map;
SELECT * FROM Game;
SELECT * FROM Leaderboard;
SELECT * FROM Achievements;
SELECT * FROM Mission;
INSERT INTO Mission
VALUES (1, true, 'kill ten enemies', '500 R6 credits');

SELECT * FROM Incorporates;

CREATE TABLE Provided_on (
    platform_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    company_id INTEGER NOT NULL,
    PRIMARY KEY (platform_id, game_id, company_id),
    FOREIGN KEY (platform_id) REFERENCES Platform(platform_id),
    FOREIGN KEY (game_id) REFERENCES Game(game_id),
    FOREIGN KEY (company_id) REFERENCES Company(company_id)
);

INSERT INTO Provided_on
VALUES (4, 5, 88);


SELECT * FROM Provided_on;


CREATE TABLE Platform (
    platform_id INTEGER NOT NULL,
    platform_name VARCHAR(50) NOT NULL,
    price_cad FLOAT DEFAULT 0,
    PRIMARY KEY (platform_id)
);

SELECT * FROM Platform;

CREATE TABLE Review (
    review_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    author VARCHAR(50) NOT NULL,
    rating FLOAT DEFAULT 0,
    review_description VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (review_id, game_id),
    FOREIGN KEY (game_id) REFERENCES Game(game_id)
);

INSERT INTO Review
VALUES (4, 10, 'Evan Vink', 4.3, 'Fun game but some Bugs');



SELECT * FROM Review;

CREATE TABLE Company (
    company_id INTEGER NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (company_id)
);

CREATE TABLE Lead_team (
    lead_id INTEGER NOT NULL UNIQUE,
    employee_id INTEGER NOT NULL,
    office_number INTEGER DEFAULT NULL,
    PRIMARY KEY (lead_id, employee_id),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);


SELECT * FROM Lead_team;

SELECT email
FROM Employee
WHERE employee_id IN (
	SELECT employee_id
    FROM Lead_team
);


INSERT INTO Lead_team
VALUES (2, 4, 99);


SELECT office_number FROM Lead_team
WHERE lead_id = 1;


CREATE TABLE Developer (
    employee_id INTEGER NOT NULL,
    desk_number INTEGER DEFAULT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

INSERT INTO Developer
VALUES (2, 22), (3, 55);

SELECT * FROM Developer;

CREATE TABLE Employee (
    employee_id INTEGER NOT NULL,
    company_id INTEGER NOT NULL,
    employee_name CHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    salary FLOAT DEFAULT 0,
    employee_schedule VARCHAR(100) DEFAULT NULL,
    hired_date VARCHAR(11) DEFAULT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (company_id) REFERENCES Company(company_id)
);

SELECT employee_name, salary
FROM Employee
WHERE salary > 100000;


SELECT desk_number
FROM Developer
WHERE employee_id = (
    SELECT employee_id
    FROM Employee
    WHERE employee_name = 'Tommy Phuong'
);

SELECT * FROM Employee;


CREATE TABLE Team (
    lead_id INTEGER NOT NULL,
    team_id INTEGER NOT NULL,
    employee_id INTEGER NOT NULL,
    team_size INTEGER DEFAULT 0,
    start_date VARCHAR(11) DEFAULT NULL,
    end_date VARCHAR(11) DEFAULT NULL,
    status CHAR(30) DEFAULT 'Active',
    PRIMARY KEY (lead_id, team_id),
    FOREIGN KEY (lead_id, employee_id) REFERENCES Lead_team(lead_id, employee_id)
);

SELECT * FROM Team;

CREATE TABLE Team_Location (
    lead_id INTEGER NOT NULL,
    team_id INTEGER NOT NULL,
    location VARCHAR(100) NOT NULL,
    PRIMARY KEY (lead_id, team_id, location),
    FOREIGN KEY (lead_id, team_id) REFERENCES Team(lead_id, team_id)
);

INSERT INTO Team_Location 
VALUES (1, 1, 'Vancouver');


SELECT * FROM Team_Location;

INSERT INTO Player (player_id, username, password)
VALUES (12, 'Hennessey', 'hello');

INSERT INTO Player (player_id, username, password)
VALUES (10, 'mister', 'bye');

INSERT INTO Friend (player_id, friend_id)
VALUES (10, 12);

INSERT INTO Game
VALUES (1, 'RainbowSix', 99, 2015, 70);

INSERT INTO Game
VALUES (5, 'Need for Speed', 88, 2015, 50);

INSERT INTO Game
VALUES (3, 'World of Warcraft', 77, 2004, 18);

INSERT INTO Game
VALUES (10, 'OverWatch', 77, 2016, 15); 

INSERT INTO Game
VALUES (9, 'Call of Duty Black Ops 6', 66, 2024, 100);

SELECT g.title, r.rating, r.review_description
FROM Game g
JOIN Review r ON g.game_id = r.game_id
WHERE r.rating > 4.0 AND g.price_cad < 21;



INSERT INTO Company
VALUES (99, 'Ubisoft');
INSERT INTO Company
VALUES (88, 'EA Games');
INSERT INTO Company
VALUES (77, 'Blizzard');
INSERT INTO Company
VALUES (66, 'Treyarch');


SELECT weapon_name
FROM Weapon
WHERE weapon_type = 'Two-Handed Sword' AND rarity = 'Legendary' AND damage > 700;

SELECT weapon_name
FROM Weapon
WHERE weapon_type = 'Staff' OR weapon_type = 'One-Handed Glaives' AND damage < 800;


SELECT p.platform_name
FROM Game g
JOIN Provided_on pro ON g.game_id = pro.game_id
JOIN Platform p ON pro.platform_id = p.platform_id
WHERE g.title = 'RainbowSix';

SELECT p.platform_name
From Player player
JOIN Friend f ON player.player_id = f.player_id
JOIN Player fp ON f.friend_id = fp.player_id
JOIN PlatformOwns po ON fp.player_id = po.player_id
JOIN Platform p ON po.platform_id = p.platform_id
WHERE f.friend_id = 12;



SELECT * FROM Team;
SELECT * FROM PlatformOwns;
SELECT * FROM Provided_on;
SELECT * FROM Platform;
Select * from Player;
Select * from Friend;
Select * from Game;
Select * from Company;
Select * from Leaderboard;

INSERT INTO Leaderboard
VALUES (1, 12, 100);

INSERT INTO Characters
VALUES (1, 1, 1, 1, 1, 1, 1);