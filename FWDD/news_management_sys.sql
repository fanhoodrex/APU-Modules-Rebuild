-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 11, 2020 at 04:21 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `news_management_sys`
--

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `author` int(11) NOT NULL,
  `heading` varchar(150) NOT NULL,
  `img` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `catid` int(11) NOT NULL,
  `dtcreated` datetime NOT NULL,
  `dtupdated` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `author`, `heading`, `img`, `description`, `catid`, `dtcreated`, `dtupdated`) VALUES
(1, 1, 'Chelsea\'s Christian Pulisic is not your wonderboy anymore', '/img/1.jpg', '                                                            Christian Pulisic is but 20 years old and the number of effusive words already written about him is staggering.                  His classic speed. His majestic acceleration. His touch, which allows him to keep the ball so close to his feet that defenders can only trip or wave at him as he flies past. The near clairvoyance with which he finds space amid a thicket of defenders near the goal. The way he shoots, like an archer. The way he sets his jaw, like a bouncer.                  EDITOR\'S PICKS                  Top 30 players under 21 in men\'s soccer                  Freddy Adu: \'I\'m not ready to give it up\'                  - Viewers\' guide: Stream ESPN+ in U.S.                  - Follow Transfer Talk LIVE                  - Fantasy: Set lineups, check scores!                  To be clear, the enthusiasm is warranted. Christian Pulisic is the most talented player in American soccer history. And, should he pull it off, what he is about to do -- that is, play for Chelsea in the English Premier League -- will be one of the most impressive feats in American sports history. Yes, Tim Howard played for Manchester United, but he was a goalkeeper; and yes, Clint Dempsey and Landon Donovan made the move to the EPL as well, but they debuted at smaller clubs in Fulham and Everton.                  Pulisic is different. By joining Chelsea, he is the first American aiming to star for one of the game\'s largest clubs. Nearly half the population of the planet watches the Premier League, more than 3 billion people a season. If Pulisic, a young, fresh-faced American, succeeds -- if he scores and dazzles and captivates fans in the U.S. and Europe and China and India and all over Africa -- it changes the calculus on him. His ceiling isn\'t Landon Donovan anymore. It\'s Lionel Messi.                                                                                        ', 1, '2020-10-11 07:50:37', '2020-10-11 13:42:36'),
(4, 1, 'Demo 2', '/img/2.jpg', 'Christian Pulisic is but 20 years old and the number of effusive words already written about him is staggering.\r\n                  His classic speed. His majestic acceleration. His touch, which allows him to keep the ball so close to his feet that defenders can only trip or wave at him as he flies past. The near clairvoyance with which he finds space amid a thicket of defenders near the goal. The way he shoots, like an archer. The way he sets his jaw, like a bouncer.\r\n                  EDITOR\'S PICKS\r\n                  Top 30 players under 21 in men\'s soccer\r\n                  Freddy Adu: \'I\'m not ready to give it up\'\r\n                  - Viewers\' guide: Stream ESPN+ in U.S.\r\n                  - Follow Transfer Talk LIVE\r\n                  - Fantasy: Set lineups, check scores!\r\n                  To be clear, the enthusiasm is warranted. Christian Pulisic is the most talented player in American soccer history. And, should he pull it off, what he is about to do -- that is, play for Chelsea in the English Premier League -- will be one of the most impressive feats in American sports history. Yes, Tim Howard played for Manchester United, but he was a goalkeeper; and yes, Clint Dempsey and Landon Donovan made the move to the EPL as well, but they debuted at smaller clubs in Fulham and Everton.\r\n                  Pulisic is different. By joining Chelsea, he is the first American aiming to star for one of the game\'s largest clubs. Nearly half the population of the planet watches the Premier League, more than 3 billion people a season. If Pulisic, a young, fresh-faced American, succeeds -- if he scores and dazzles and captivates fans in the U.S. and Europe and China and India and all over Africa -- it changes the calculus on him. His ceiling isn\'t Landon Donovan anymore. It\'s Lionel Messi.\r\n                \r\n                  ', 1, '2020-10-11 07:50:37', NULL),
(6, 2, 'Demo 3', '/img/3.jpg', 'Christian Pulisic is but 20 years old and the number of effusive words already written about him is staggering.\r\n                  His classic speed. His majestic acceleration. His touch, which allows him to keep the ball so close to his feet that defenders can only trip or wave at him as he flies past. The near clairvoyance with which he finds space amid a thicket of defenders near the goal. The way he shoots, like an archer. The way he sets his jaw, like a bouncer.\r\n                  EDITOR\'S PICKS\r\n                  Top 30 players under 21 in men\'s soccer\r\n                  Freddy Adu: \'I\'m not ready to give it up\'\r\n                  - Viewers\' guide: Stream ESPN+ in U.S.\r\n                  - Follow Transfer Talk LIVE\r\n                  - Fantasy: Set lineups, check scores!\r\n                  To be clear, the enthusiasm is warranted. Christian Pulisic is the most talented player in American soccer history. And, should he pull it off, what he is about to do -- that is, play for Chelsea in the English Premier League -- will be one of the most impressive feats in American sports history. Yes, Tim Howard played for Manchester United, but he was a goalkeeper; and yes, Clint Dempsey and Landon Donovan made the move to the EPL as well, but they debuted at smaller clubs in Fulham and Everton.\r\n                  Pulisic is different. By joining Chelsea, he is the first American aiming to star for one of the game\'s largest clubs. Nearly half the population of the planet watches the Premier League, more than 3 billion people a season. If Pulisic, a young, fresh-faced American, succeeds -- if he scores and dazzles and captivates fans in the U.S. and Europe and China and India and all over Africa -- it changes the calculus on him. His ceiling isn\'t Landon Donovan anymore. It\'s Lionel Messi.\r\n                \r\n                  ', 2, '2020-10-11 07:50:37', NULL),
(7, 2, 'Demo 4', '/img/4.jpg', 'Christian Pulisic is but 20 years old and the number of effusive words already written about him is staggering.\r\n                  His classic speed. His majestic acceleration. His touch, which allows him to keep the ball so close to his feet that defenders can only trip or wave at him as he flies past. The near clairvoyance with which he finds space amid a thicket of defenders near the goal. The way he shoots, like an archer. The way he sets his jaw, like a bouncer.\r\n                  EDITOR\'S PICKS\r\n                  Top 30 players under 21 in men\'s soccer\r\n                  Freddy Adu: \'I\'m not ready to give it up\'\r\n                  - Viewers\' guide: Stream ESPN+ in U.S.\r\n                  - Follow Transfer Talk LIVE\r\n                  - Fantasy: Set lineups, check scores!\r\n                  To be clear, the enthusiasm is warranted. Christian Pulisic is the most talented player in American soccer history. And, should he pull it off, what he is about to do -- that is, play for Chelsea in the English Premier League -- will be one of the most impressive feats in American sports history. Yes, Tim Howard played for Manchester United, but he was a goalkeeper; and yes, Clint Dempsey and Landon Donovan made the move to the EPL as well, but they debuted at smaller clubs in Fulham and Everton.\r\n                  Pulisic is different. By joining Chelsea, he is the first American aiming to star for one of the game\'s largest clubs. Nearly half the population of the planet watches the Premier League, more than 3 billion people a season. If Pulisic, a young, fresh-faced American, succeeds -- if he scores and dazzles and captivates fans in the U.S. and Europe and China and India and all over Africa -- it changes the calculus on him. His ceiling isn\'t Landon Donovan anymore. It\'s Lionel Messi.\r\n                \r\n                  ', 2, '2020-10-11 07:50:37', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `news_category`
--

CREATE TABLE `news_category` (
  `id` int(11) NOT NULL,
  `category` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `news_category`
--

INSERT INTO `news_category` (`id`, `category`) VALUES
(1, 'Finance'),
(2, 'Entertainment'),
(3, 'Sport');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `name`, `password`) VALUES
(1, 'fang', 'Fang', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD KEY `author` (`author`),
  ADD KEY `catid` (`catid`);

--
-- Indexes for table `news_category`
--
ALTER TABLE `news_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `news_category`
--
ALTER TABLE `news_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
