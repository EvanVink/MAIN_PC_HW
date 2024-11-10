CREATE TABLE Player (
    player_id INTEGER NOT NULL,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    PRIMARY KEY (player_id)
);

CREATE TABLE Friend (
    player_id INTEGER NOT NULL,
    friend_id INTEGER NOT NULL,
    PRIMARY KEY (player_id, friend_id),
    FOREIGN KEY (friend_id) REFERENCES Player(player_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

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

CREATE TABLE Map (
    map_id INTEGER NOT NULL,
    map_name VARCHAR(50) NOT NULL,
    map_size INTEGER DEFAULT 0,
    PRIMARY KEY (map_id)
);

CREATE TABLE Leaderboard (
    position INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    score INTEGER DEFAULT 0,
    PRIMARY KEY (position, player_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

CREATE TABLE Mission (
    mission_id INTEGER NOT NULL,
    completed BOOLEAN DEFAULT FALSE,
    mission_description CHAR(100) NOT NULL,
    reward VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (mission_id)
);

CREATE TABLE Weapon (
    weapon_id INTEGER NOT NULL,
    weapon_type CHAR(30) NOT NULL,
    rarity CHAR(30) NOT NULL,
    damage FLOAT DEFAULT 0,
    kills INTEGER DEFAULT 0,
    PRIMARY KEY (weapon_id)
);

CREATE TABLE Gear (
    gear_id INTEGER NOT NULL,
    gear_type CHAR(30) NOT NULL,
    rarity CHAR(30) NOT NULL,
    bonus_health INTEGER DEFAULT 0,
    bonus_armour INTEGER DEFAULT 0,
    PRIMARY KEY (gear_id)
);

CREATE TABLE Item (
    item_id INTEGER NOT NULL,
    item_description VARCHAR(100) NOT NULL,
    item_type CHAR(30) NOT NULL,
    price FLOAT DEFAULT 0,
    rarity CHAR(30) DEFAULT NULL,
    PRIMARY KEY (item_id)
);

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

CREATE TABLE PlatformOwns (
    platform_owned VARCHAR(30) NOT NULL,
    platform_id INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    PRIMARY KEY (platform_owned, platform_id, player_id),
    FOREIGN KEY (platform_id) REFERENCES Platform(platform_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

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

CREATE TABLE Ranks_on (
    player_id INTEGER NOT NULL,
    rank_position INTEGER NOT NULL,
    PRIMARY KEY (player_id, rank_position),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

CREATE TABLE Achieves (
    player_id INTEGER NOT NULL,
    achievement_id INTEGER NOT NULL,
    date_earned VARCHAR(11) DEFAULT NULL,
    PRIMARY KEY (player_id, achievement_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id),
    FOREIGN KEY (achievement_id) REFERENCES Achievement(achievement_id)
);

CREATE TABLE Incorporates (
    map_id INTEGER NOT NULL,
    character_id INTEGER NOT NULL,
    position INTEGER DEFAULT NULL,
    achievement_id INTEGER DEFAULT NULL,
    mission_id INTEGER DEFAULT NULL,
    game_id INTEGER NOT NULL,
    genre CHAR(30) NOT NULL,
    data_size FLOAT DEFAULT 0,
    PRIMARY KEY (map_id, character_id, position, achievement_id, mission_id),
    FOREIGN KEY (map_id) REFERENCES Map(map_id),
    FOREIGN KEY (character_id) REFERENCES Characters(character_id),
    FOREIGN KEY (position) REFERENCES Leaderboard(position),
    FOREIGN KEY (achievement_id) REFERENCES Achievement(achievement_id),
    FOREIGN KEY (mission_id) REFERENCES Mission(mission_id),
    FOREIGN KEY (game_id) REFERENCES Game(game_id)
);

CREATE TABLE Provided_on (
    platform_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    company_id INTEGER NOT NULL,
    PRIMARY KEY (platform_id, game_id, company_id),
    FOREIGN KEY (platform_id) REFERENCES Platform(platform_id),
    FOREIGN KEY (game_id) REFERENCES Game(game_id),
    FOREIGN KEY (company_id) REFERENCES Company(company_id)
);

CREATE TABLE Platform (
    platform_id INTEGER NOT NULL,
    platform_name VARCHAR(50) NOT NULL,
    price_cad FLOAT DEFAULT 0,
    PRIMARY KEY (platform_id)
);

CREATE TABLE Review (
    review_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    author VARCHAR(50) NOT NULL,
    rating FLOAT DEFAULT 0,
    review_description VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (review_id, game_id),
    FOREIGN KEY (game_id) REFERENCES Game(game_id)
);

CREATE TABLE Company (
    company_id INTEGER NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (company_id)
);

CREATE TABLE Lead_team (
    lead_id INTEGER NOT NULL,
    employee_id INTEGER NOT NULL,
    office_number INTEGER DEFAULT NULL,
    PRIMARY KEY (lead_id, employee_id),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

CREATE TABLE Developer (
    employee_id INTEGER NOT NULL,
    desk_number INTEGER DEFAULT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

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

CREATE TABLE Team (
    lead_id INTEGER NOT NULL,
    team_id INTEGER NOT NULL,
    team_size INTEGER DEFAULT 0,
    start_date VARCHAR(11) DEFAULT NULL,
    end_date VARCHAR(11) DEFAULT NULL,
    status CHAR(30) DEFAULT 'Active',
    PRIMARY KEY (lead_id, team_id),
    FOREIGN KEY (lead_id) REFERENCES Lead_team(lead_id)
);

CREATE TABLE Team_Location (
    lead_id INTEGER NOT NULL,
    team_id INTEGER NOT NULL,
    location VARCHAR(100) NOT NULL,
    PRIMARY KEY (lead_id, team_id, location),
    FOREIGN KEY (lead_id) REFERENCES Lead_team(lead_id),
    FOREIGN KEY (team_id) REFERENCES Team(team_id)
);

INSERT INTO Player (player_id, username, password)
VALUES (12, 'Hennessey', 'hello');

INSERT INTO Player (player_id, username, password)
VALUES (10, 'mister', 'bye');

INSERT INTO Friend (player_id, friend_id)
VALUES (10, 12);

INSERT INTO Game
VALUES (1, RainbowSix, 111, 2015, 70);

INSERT INTO Leaderboad
VALUES (1, 1, 100);

INSERT INTO Characters
VALUES (1, 1, 1, 1, 1, 1, 1);