-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 02 Oca 2024, 21:02:55
-- Sunucu sürümü: 10.4.32-MariaDB
-- PHP Sürümü: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kullanıcılar`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yatak`
--

CREATE TABLE `yatak` (
  `klavuz` int(10) NOT NULL,
  `yatakNo` int(11) NOT NULL,
  `tc` text NOT NULL,
  `ad` text NOT NULL,
  `soyad` text NOT NULL,
  `yaş` text NOT NULL,
  `cinsiyet` text NOT NULL,
  `telefonNumarası` text NOT NULL,
  `yatakTürü` text NOT NULL,
  `kanGrubu` text NOT NULL,
  `adres` text NOT NULL,
  `sigorta` text NOT NULL,
  `yatakKonum` text NOT NULL,
  `acilTelefonNo` text NOT NULL,
  `başlangıçTarihi` text NOT NULL,
  `bitişTarihi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_turkish_ci;

--
-- Tablo döküm verisi `yatak`
--

INSERT INTO `yatak` (`klavuz`, `yatakNo`, `tc`, `ad`, `soyad`, `yaş`, `cinsiyet`, `telefonNumarası`, `yatakTürü`, `kanGrubu`, `adres`, `sigorta`, `yatakKonum`, `acilTelefonNo`, `başlangıçTarihi`, `bitişTarihi`) VALUES
(1, 600, '45890134528', 'barış', 'alışkan', '20', 'erkek', '05389017856', 'ev tipi hasta yatağı', 'A Rh+', 'sancaktepe yenidoğan', 'var', 'zemin kat 1.oda', '05389017856', '2023-11-29', '2023-12-29'),
(2, 601, '34567890124', 'yunus emre', 'alışkan', '18', 'erkek', '05673490567', 'motorlu hasta yatağı', 'O Rh+', 'bebek sahil', 'var', 'zemin kat 1.oda', '05673490567', '2023-11-29', '2024-01-05'),
(3, 602, '30287990141', 'sude', 'kaya', '4', 'erkek', '05057832765', 'motorlu hasta yatağı', 'B Rh+', 'sancaktepe atatürk mahallesi', 'yok', 'zemin kat 2.oda', '05057832765', '2024-12-03', '2024-12-05'),
(4, 603, '', '', '', '', '', '', 'motorlu hasta yatağı', '', '', '', 'zemin kat 2.oda', '', '', ''),
(5, 604, '', '', '', '0', '', '', 'motorlu hasta yatağı', '', '', '', 'zemin kat 2.oda', '', '', ''),
(10, 605, '', '', '', '0', '', '', 'yarı otomatik hasta yatağı', '', '', '', 'zemin kat 3.oda', '', '', ''),
(11, 606, '', '', '', '', '', '', 'otomatik hasta yatağı', '', '', '', 'zemin kat 3.oda', '', '', ''),
(12, 607, '25136825945', 'berna', 'dağ', '32', 'kadın', '05387562345', 'otomatik hasta yatağı', 'AB Rh+', 'maltepe sahil', 'var', 'zemin kat 3.oda', '05387562345', '2024-01-01', '2024-01-11'),
(13, 608, '38934567823', 'osman', 'kayalar', '30', 'erkek', '05317892341', 'ev tipi hasta yatağı', 'O Rh-', 'ümraniye merkez', 'yok', '1.kat 4.oda', '05317892341', '2024-01-01', '2024-01-10'),
(14, 609, '', '', '', '', '', '', 'motorlu hasta yatağı', '', '', '', '1.kat 4.oda', '', '', ''),
(15, 610, '', '', '', '', '', '', 'manuel hasta yatağı', '', '', '', '1.kat 4.oda', '', '', ''),
(16, 611, '32456178903', 'emre', 'uygun', '18', 'erkek', '05050567890', 'manuel hasta yatağı', 'A Rh+', 'kadıköy moda', 'var', '1.kat 5.oda', '05050567890', '2024-01-01', '2024-01-28'),
(17, 612, '', '', '', '', '', '', 'otoatik hasta yatağı', '', '', '', '1.kat 5.oda', '', '', ''),
(18, 613, '', '', '', '', '', '', 'otomatik hasta yatağı', '', '', '', '1.kat 5.oda', '', '', ''),
(19, 614, '', '', '', '', '', '', 'otomatik hasta yatağı', '', '', '', '1.kat 6.oda', '', '', ''),
(20, 615, '', '', '', '', '', '', 'ev tipi hasta yatağı', '', '', '', '1.kat 6.oda', '', '', ''),
(21, 616, '', '', '', '', '', '', 'ev tipi hasta yatağı', '', '', '', '1.kat 6.oda', '', '', ''),
(22, 617, '', '', '', '', '', '', 'motorlu hasta yatağı', '', '', '', '2.kat 7.oda', '', '', ''),
(23, 618, '', '', '', '', '', '', 'otomatik hasta yatağı', '', '', '', '2.kat 7.oda', '', '', ''),
(24, 619, '', '', '', '', '', '', 'otomatik hasta yatağı', '', '', '', '2.kat 7.oda', '', '', ''),
(25, 620, '', '', '', '', '', '', 'manuel hasta yatağı', '', '', '', '2.kat 8.oda', '', '', '');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `yatak`
--
ALTER TABLE `yatak`
  ADD PRIMARY KEY (`klavuz`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `yatak`
--
ALTER TABLE `yatak`
  MODIFY `klavuz` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
