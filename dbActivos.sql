-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 15, 2022 at 05:34 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbActivos`
--

-- --------------------------------------------------------

--
-- Table structure for table `activo`
--

CREATE TABLE `activo` (
  `DTYPE` varchar(31) NOT NULL,
  `id_activo` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `activo`
--

INSERT INTO `activo` (`DTYPE`, `id_activo`, `nombre`) VALUES
('Crypto', 1, 'Bitcoin'),
('Crypto', 2, 'Ethereum'),
('Crypto', 3, 'Tether'),
('Crypto', 4, 'USD Coin'),
('Crypto', 5, 'BNB'),
('Crypto', 6, 'Cardano'),
('Crypto', 7, 'XRP'),
('Crypto', 8, 'Binance USD'),
('Crypto', 9, 'Solana'),
('Crypto', 10, 'Dogecoin'),
('Crypto', 11, 'Polkadot'),
('Crypto', 12, 'Shiba Inu'),
('Crypto', 13, 'Lido Staked Ether'),
('Crypto', 14, 'Avalanche'),
('Crypto', 15, 'Polygon'),
('Crypto', 16, 'Dai'),
('Crypto', 17, 'TRON'),
('Crypto', 18, 'Wrapped Bitcoin'),
('Crypto', 19, 'Ethereum Classic'),
('Crypto', 20, 'OKB'),
('Crypto', 21, 'LEO Token'),
('Crypto', 22, 'Litecoin'),
('Crypto', 23, 'NEAR Protocol'),
('Crypto', 24, 'FTX'),
('Crypto', 25, 'Chainlink'),
('Crypto', 26, 'Uniswap'),
('Crypto', 27, 'Cronos'),
('Crypto', 28, 'Cosmos Hub'),
('Crypto', 29, 'Stellar'),
('Crypto', 30, 'Monero'),
('Crypto', 31, 'Flow'),
('Crypto', 32, 'Bitcoin Cash'),
('Crypto', 33, 'Aerarium Fi'),
('Crypto', 34, 'Algorand'),
('Crypto', 35, 'VeChain'),
('Crypto', 36, 'Filecoin'),
('Crypto', 37, 'Internet Computer'),
('Crypto', 38, 'ApeCoin'),
('Crypto', 39, 'Decentraland'),
('Crypto', 40, 'Chain'),
('Crypto', 41, 'The Sandbox'),
('Crypto', 42, 'Hedera'),
('Crypto', 43, 'Axie Infinity'),
('Crypto', 44, 'Tezos'),
('Crypto', 45, 'Quant'),
('Crypto', 46, 'Lido DAO'),
('Crypto', 47, 'Aave'),
('Crypto', 48, 'Theta Network'),
('Crypto', 49, 'Frax'),
('Crypto', 50, 'Elrond'),
('Crypto', 51, 'Celsius Network'),
('Crypto', 52, 'EOS'),
('Crypto', 53, 'TrueUSD'),
('Crypto', 54, 'Bitcoin SV'),
('Crypto', 55, 'Chiliz'),
('Crypto', 56, 'KuCoin'),
('Crypto', 57, 'Helium'),
('Crypto', 58, 'cUSDC'),
('Crypto', 59, 'The Graph'),
('Crypto', 60, 'Fantom'),
('Crypto', 61, 'IOTA'),
('Crypto', 62, 'Zcash'),
('Crypto', 63, 'Huobi BTC'),
('Crypto', 64, 'cETH'),
('Crypto', 65, 'BitTorrent'),
('Crypto', 66, 'Maker'),
('Crypto', 67, 'eCash'),
('Crypto', 68, 'Klaytn'),
('Crypto', 69, 'Synthetix Network'),
('Crypto', 70, 'Pax Dollar'),
('Crypto', 71, 'cDAI'),
('Crypto', 72, 'THORChain'),
('Crypto', 73, 'Huobi'),
('Crypto', 74, 'NEO'),
('Crypto', 75, 'USDD'),
('Crypto', 76, 'Gate'),
('Crypto', 77, 'Arweave'),
('Crypto', 78, 'Neutrino USD'),
('Crypto', 79, 'PancakeSwap'),
('Crypto', 80, 'Zilliqa'),
('Crypto', 81, 'Basic Attention'),
('Crypto', 82, 'BitDAO'),
('Crypto', 83, 'Stacks'),
('Crypto', 84, 'Enjin Coin'),
('Crypto', 85, 'Radix'),
('Crypto', 86, 'STEPN'),
('Crypto', 87, 'Amp'),
('Crypto', 88, 'PAX Gold'),
('Crypto', 89, 'Waves'),
('Crypto', 90, 'Dash'),
('Crypto', 91, 'Loopring'),
('Crypto', 92, 'Tenset'),
('Crypto', 93, 'Kava'),
('Crypto', 94, 'NEXO'),
('Crypto', 95, 'Curve DAO'),
('Crypto', 96, 'Bitcoin Gold'),
('Crypto', 97, 'Kusama'),
('Crypto', 98, 'DeFiChain'),
('Crypto', 99, 'Gala'),
('Crypto', 100, 'Evmos');

-- --------------------------------------------------------

--
-- Table structure for table `compras`
--

CREATE TABLE `compras` (
  `id` int(11) NOT NULL,
  `cantidad` double DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `activo_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activo`
--
ALTER TABLE `activo`
  ADD PRIMARY KEY (`id_activo`);

--
-- Indexes for table `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_g231rh6d9h5up5rn6plm3thw` (`activo_id`),
  ADD KEY `FK_e8rtk99xsntmitl4k0u60emhy` (`usuario_id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activo`
--
ALTER TABLE `activo`
  MODIFY `id_activo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `compras`
--
ALTER TABLE `compras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `FK_e8rtk99xsntmitl4k0u60emhy` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `FK_g231rh6d9h5up5rn6plm3thw` FOREIGN KEY (`activo_id`) REFERENCES `activo` (`id_activo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
