-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Des 2021 pada 00.49
-- Versi server: 10.4.13-MariaDB
-- Versi PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpesawat`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `idKategori` int(11) NOT NULL,
  `namaKategori` varchar(255) NOT NULL,
  `tipeKursi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`idKategori`, `namaKategori`, `tipeKursi`) VALUES
(1, 'Utama', 300000),
(3, 'Ekonomi', 150000),
(4, 'Bisnis', 250000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penumpang`
--

CREATE TABLE `penumpang` (
  `idPenumpang` int(11) NOT NULL,
  `namaPenumpang` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `telepon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penumpang`
--

INSERT INTO `penumpang` (`idPenumpang`, `namaPenumpang`, `alamat`, `telepon`) VALUES
(1, 'Ferdiansyah', 'Probolinggo', '085856004598'),
(2, 'Tirta', 'Jember', '082234567892'),
(4, 'Nia', 'Jember', '081234555444'),
(5, 'Rosi', 'Malang', '089698220214');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesawat`
--

CREATE TABLE `pesawat` (
  `idPesawat` int(11) NOT NULL,
  `idkategori` int(11) NOT NULL,
  `namaPesawat` varchar(255) NOT NULL,
  `jenisPesawat` varchar(255) NOT NULL,
  `hargaTiket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pesawat`
--

INSERT INTO `pesawat` (`idPesawat`, `idkategori`, `namaPesawat`, `jenisPesawat`, `hargaTiket`) VALUES
(1, 1, 'Garuda', 'Utama', 2000000),
(2, 3, 'Batik Air', 'Utama', 1000000),
(3, 4, 'Lion Air', 'Bisnis', 1500000),
(4, 3, 'Garuda', 'Ekonomi', 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(11) NOT NULL,
  `idPenumpang` int(11) NOT NULL,
  `idPesawat` int(11) NOT NULL,
  `jumlahTiket` int(11) NOT NULL,
  `totalBayar` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `idPenumpang`, `idPesawat`, `jumlahTiket`, `totalBayar`) VALUES
(5, 1, 1, 2, 4500000),
(6, 2, 2, 2, 2600000),
(7, 4, 3, 2, 3300000),
(11, 1, 3, 2, 3000000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`idKategori`);

--
-- Indeks untuk tabel `penumpang`
--
ALTER TABLE `penumpang`
  ADD PRIMARY KEY (`idPenumpang`);

--
-- Indeks untuk tabel `pesawat`
--
ALTER TABLE `pesawat`
  ADD PRIMARY KEY (`idPesawat`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `kategori`
--
ALTER TABLE `kategori`
  MODIFY `idKategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `penumpang`
--
ALTER TABLE `penumpang`
  MODIFY `idPenumpang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pesawat`
--
ALTER TABLE `pesawat`
  MODIFY `idPesawat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
