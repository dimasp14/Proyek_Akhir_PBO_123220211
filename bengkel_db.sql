-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2026 at 03:07 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bengkel_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id` int(11) NOT NULL,
  `pelanggan_id` int(11) DEFAULT NULL,
  `plat_nomor` varchar(20) DEFAULT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `merk` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`id`, `pelanggan_id`, `plat_nomor`, `jenis`, `merk`) VALUES
(1, 1, '343e', 'eee', 'eee'),
(2, 2, 'hhh', 'eee', 'rem'),
(3, 1, 'AB1234CD', 'Motor', 'Honda'),
(4, 2, 'AD5678EF', 'Mobil', 'Toyota'),
(5, 3, 'B9988GH', 'Motor', 'Yamaha'),
(6, 4, 'AA1122BB', 'Mobil', 'Honda'),
(7, 5, 'K2233CC', 'Motor', 'Suzuki'),
(8, 6, 'H3344DD', 'Mobil', 'Mitsubishi'),
(9, 7, 'R4455EE', 'Motor', 'Kawasaki'),
(10, 8, 'G5566FF', 'Mobil', 'Daihatsu'),
(11, 9, 'AB6677GG', 'Motor', 'Honda'),
(12, 10, 'AD7788HH', 'Mobil', 'Toyota'),
(13, 11, 'B8899II', 'Motor', 'Yamaha'),
(14, 12, 'AA9900JJ', 'Mobil', 'Suzuki'),
(15, 13, 'K1010KK', 'Motor', 'Honda'),
(16, 14, 'H2020LL', 'Mobil', 'Nissan'),
(17, 15, 'R3030MM', 'Motor', 'Yamaha'),
(18, 16, 'G4040NN', 'Mobil', 'Toyota'),
(19, 17, 'AB5050OO', 'Motor', 'Honda'),
(20, 18, 'AD6060PP', 'Mobil', 'Daihatsu'),
(21, 19, 'B7070QQ', 'Motor', 'Suzuki'),
(22, 20, 'AA8080RR', 'Mobil', 'Mitsubishi');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nama`, `no_hp`, `alamat`) VALUES
(1, '', '', ''),
(2, ' hhh', '090090', '8okg'),
(3, 'Budi Santoso', '081234567890', 'Klaten'),
(4, 'Andi Pratama', '082233445566', 'Yogyakarta'),
(5, 'Rizky Saputra', '085712341234', 'Solo'),
(6, 'Dimas Saputra', '081111111111', 'Purworejo'),
(7, 'Agus Wijaya', '082222222222', 'Magelang'),
(8, 'Fajar Nugroho', '083333333333', 'Semarang'),
(9, 'Rian Setiawan', '084444444444', 'Kebumen'),
(10, 'Yoga Pratama', '085555555555', 'Klaten'),
(11, 'Ilham Ramadhan', '086666666666', 'Boyolali'),
(12, 'Aldi Firmansyah', '087777777777', 'Wonogiri'),
(13, 'Bagus Hidayat', '088888888888', 'Sragen'),
(14, 'Kevin Saputra', '089999999999', 'Salatiga'),
(15, 'Rama Putra', '081212121212', 'Temanggung'),
(16, 'Rizal Maulana', '082323232323', 'Wonosobo'),
(17, 'Arif Setiawan', '083434343434', 'Purwokerto'),
(18, 'Doni Kurniawan', '084545454545', 'Cilacap'),
(19, 'Eko Saputro', '085656565656', 'Banjarnegara'),
(20, 'Galih Prakoso', '086767676767', 'Pekalongan'),
(21, 'Hendra Wijaya', '087878787878', 'Tegal'),
(22, 'Iqbal Ramadhan', '088989898989', 'Kudus');

-- --------------------------------------------------------

--
-- Table structure for table `servis`
--

CREATE TABLE `servis` (
  `id` int(11) NOT NULL,
  `kendaraan_id` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jenis_servis` varchar(50) DEFAULT NULL,
  `biaya` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `servis`
--

INSERT INTO `servis` (`id`, `kendaraan_id`, `tanggal`, `jenis_servis`, `biaya`) VALUES
(2, 1, '2026-05-17', 'Ganti Oli', 75000),
(3, 2, '2026-05-17', 'Tune Up', 350000),
(4, 3, '2026-05-17', 'Servis Rutin', 150000),
(5, 4, '2026-05-18', 'Ganti Ban', 500000),
(6, 5, '2026-05-18', 'Servis Mesin', 450000),
(7, 6, '2026-05-18', 'Spooring', 200000),
(8, 7, '2026-05-19', 'Balancing', 150000),
(9, 8, '2026-05-19', 'Ganti Aki', 700000),
(10, 9, '2026-05-19', 'Ganti Kampas Rem', 250000),
(11, 10, '2026-05-19', 'Servis AC', 400000),
(12, 11, '2026-05-20', 'Tune Up', 300000),
(13, 12, '2026-05-20', 'Ganti Oli', 80000),
(14, 13, '2026-05-20', 'Servis Injeksi', 350000),
(15, 14, '2026-05-20', 'Ganti Velg', 1200000),
(16, 15, '2026-05-21', 'Servis Kelistrikan', 500000),
(17, 16, '2026-05-21', 'Ganti Filter Udara', 120000),
(18, 17, '2026-05-21', 'Servis Rutin', 175000),
(19, 18, '2026-05-22', 'Ganti Oli', 85000),
(20, 19, '2026-05-22', 'Tune Up', 325000),
(21, 20, '2026-05-22', 'Servis Besar', 1500000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', 'admin123', 'admin'),
(2, 'kasir', 'kasir123', 'kasir');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pelanggan_id` (`pelanggan_id`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `servis`
--
ALTER TABLE `servis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kendaraan_id` (`kendaraan_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `servis`
--
ALTER TABLE `servis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD CONSTRAINT `kendaraan_ibfk_1` FOREIGN KEY (`pelanggan_id`) REFERENCES `pelanggan` (`id`);

--
-- Constraints for table `servis`
--
ALTER TABLE `servis`
  ADD CONSTRAINT `servis_ibfk_1` FOREIGN KEY (`kendaraan_id`) REFERENCES `kendaraan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
