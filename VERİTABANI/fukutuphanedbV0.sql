-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 15 Haz 2020, 20:57:07
-- Sunucu sürümü: 8.0.18
-- PHP Sürümü: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `fukutuphanedb`
--
CREATE DATABASE IF NOT EXISTS `fukutuphanedb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `fukutuphanedb`;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ayarlar`
--

DROP TABLE IF EXISTS `ayarlar`;
CREATE TABLE IF NOT EXISTS `ayarlar` (
  `odunc_asim_suresi` int(11) NOT NULL,
  `gunluk_asim_cezasi` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bolumler`
--

DROP TABLE IF EXISTS `bolumler`;
CREATE TABLE IF NOT EXISTS `bolumler` (
  `bolum_id` int(11) NOT NULL AUTO_INCREMENT,
  `bolum_adi` varchar(255) NOT NULL,
  `fakulte_id` int(11) NOT NULL,
  PRIMARY KEY (`bolum_id`),
  KEY `fakulte_id` (`fakulte_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `bolumler`
--

INSERT INTO `bolumler` (`bolum_id`, `bolum_adi`, `fakulte_id`) VALUES
(15, 'Yazılım Mühendisliği', 9);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `fakulteler`
--

DROP TABLE IF EXISTS `fakulteler`;
CREATE TABLE IF NOT EXISTS `fakulteler` (
  `fakulte_id` int(11) NOT NULL AUTO_INCREMENT,
  `fakulte_adi` varchar(255) NOT NULL,
  PRIMARY KEY (`fakulte_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `fakulteler`
--

INSERT INTO `fakulteler` (`fakulte_id`, `fakulte_adi`) VALUES
(9, 'Teknoloji Fakültesi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gorevli_hesaplar`
--

DROP TABLE IF EXISTS `gorevli_hesaplar`;
CREATE TABLE IF NOT EXISTS `gorevli_hesaplar` (
  `hesap_id` int(11) NOT NULL AUTO_INCREMENT,
  `hesap_ad_soyad` varchar(255) NOT NULL,
  `hesap_kullanici_adi` varchar(255) NOT NULL,
  `hesap_sifre` varchar(255) NOT NULL,
  `hesap_guvenlik_soru` varchar(255) NOT NULL,
  `hesap_guvenlik_cevap` varchar(255) NOT NULL,
  PRIMARY KEY (`hesap_id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `gorevli_hesaplar`
--

INSERT INTO `gorevli_hesaplar` (`hesap_id`, `hesap_ad_soyad`, `hesap_kullanici_adi`, `hesap_sifre`, `hesap_guvenlik_soru`, `hesap_guvenlik_cevap`) VALUES
(4, 'osman karadeniz', 'jetali500', 'asd', 'adın ne ?', 'ahmet'),
(23, 'abdullah jarakas', 'jarkas', '123123', 'Telefon numaranızın son 3 hanesi kaçtır ?', '123'),
(22, 'asd', 'sd', 'sd', 'En sevdiğiniz yemek hangisidir?', 'asd'),
(21, 'as', 's', 'dd', 'Telefon numaranızın son 3 hanesi kaçtır ?', 's'),
(24, 'asd', 'asd', '123', 'Telefon numaranızın son 3 hanesi kaçtır ?', '1234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `islemler`
--

DROP TABLE IF EXISTS `islemler`;
CREATE TABLE IF NOT EXISTS `islemler` (
  `islem_id` int(11) NOT NULL AUTO_INCREMENT,
  `islem_tip` varchar(255) NOT NULL,
  `ogrenci_no` varchar(255) NOT NULL,
  `kitap_isbn` varchar(255) NOT NULL,
  `tarih` varchar(255) NOT NULL,
  `odenen_ceza` int(11) NOT NULL,
  PRIMARY KEY (`islem_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `islemler`
--

INSERT INTO `islemler` (`islem_id`, `islem_tip`, `ogrenci_no`, `kitap_isbn`, `tarih`, `odenen_ceza`) VALUES
(1, '123123', '123123', '12312', '2015-06-20', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitaplar`
--

DROP TABLE IF EXISTS `kitaplar`;
CREATE TABLE IF NOT EXISTS `kitaplar` (
  `kitap_id` int(11) NOT NULL AUTO_INCREMENT,
  `kitap_baslik` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `kitap_yazar` varchar(255) NOT NULL,
  `kitap_turleri_id` int(11) NOT NULL,
  `kitap_isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `kitap_baski_sayi` int(255) NOT NULL,
  `kitap_baski_yil` int(255) NOT NULL,
  `kitap_yayinevi` varchar(255) NOT NULL,
  `kitap_sayfa_sayi` int(255) NOT NULL,
  `kitap_fiyat` double NOT NULL,
  `kitap_mevcutmu` bit(1) NOT NULL,
  PRIMARY KEY (`kitap_id`),
  KEY `kitap_turleri_id` (`kitap_turleri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `kitaplar`
--

INSERT INTO `kitaplar` (`kitap_id`, `kitap_baslik`, `kitap_yazar`, `kitap_turleri_id`, `kitap_isbn`, `kitap_baski_sayi`, `kitap_baski_yil`, `kitap_yayinevi`, `kitap_sayfa_sayi`, `kitap_fiyat`, `kitap_mevcutmu`) VALUES
(84, 'Bilinmeyen Bir Kadının Mektubu', 'Stefan Zweig', 34, '9786053606604', 1, 2019, 'Türkiye İş Bankası Kültür Yayınları', 68, 9, b'1'),
(85, 'Altıncı Koğuş', 'Anton Çehov', 34, '9786052951569', 1, 2017, 'Türkiye İş Bankası Kültür Yayınları', 68, 5, b'1'),
(86, 'Bir İdam Mahkumunun Son Günü', 'Victor Hugo', 34, '9786053609902', 1, 2013, 'Türkiye İş Bankası Kültür Yayınları', 118, 23, b'1'),
(87, 'Satranç', 'Stefan Zweig', 34, '9786053606116', 1, 2019, 'Türkiye İş Bankası Kültür Yayınları', 83, 6.4, b'1'),
(88, 'Sineklerin Tanrıs', 'William Golding', 34, '9789754582901', 1, 2019, 'Türkiye İş Bankası Kültür Yayınları', 261, 12, b'1'),
(89, 'Dönüşüm', 'Franz Kafka', 34, '9786053609322', 1, 2019, 'Türkiye İş Bankası Kültür Yayınları', 74, 5, b'1'),
(90, 'The Heart Principle', 'Helen Hoang', 35, '9780451490841', 1, 2020, 'HarperTeen', 368, 50, b'0'),
(91, 'Cemile', 'Cengiz Aytmatov', 35, '9786051553900', 1, 2020, 'Ötüken Neşriyat', 80, 6, b'1'),
(92, 'Sıfır Kilometre', 'Beyza Alkoç', 35, '9786057611147', 1, 2019, 'İndigo Kitap', 360, 25, b'1'),
(93, 'Böğürtlen Kışı', 'Sarah Jio', 35, '9789759997199', 1, 2011, 'Arkadya Yayınları', 360, 23.5, b'1'),
(94, 'Fakat Müzeyyen Bu Derin Bir Tutku', 'İlhami Algör', 35, '9789750516832', 1, 2014, 'İletişim Yayıncılık', 59, 22, b'1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitap_turleri`
--

DROP TABLE IF EXISTS `kitap_turleri`;
CREATE TABLE IF NOT EXISTS `kitap_turleri` (
  `kitap_turleri_id` int(11) NOT NULL AUTO_INCREMENT,
  `kitap_tur` varchar(255) NOT NULL,
  PRIMARY KEY (`kitap_turleri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `kitap_turleri`
--

INSERT INTO `kitap_turleri` (`kitap_turleri_id`, `kitap_tur`) VALUES
(34, 'Dünya Klasikleri'),
(35, 'Aşk'),
(36, 'Psikoloji'),
(37, 'Roman'),
(38, 'Gençlik'),
(39, 'Tarih'),
(40, 'Çocuk'),
(41, 'Kişisel Gelişim'),
(43, 'Polisiye'),
(44, 'Sosyoloji');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ogrenciler`
--

DROP TABLE IF EXISTS `ogrenciler`;
CREATE TABLE IF NOT EXISTS `ogrenciler` (
  `ogrenci_id` int(11) NOT NULL AUTO_INCREMENT,
  `ogrenci_ad_soyad` varchar(255) NOT NULL,
  `ogrenci_no` varchar(255) NOT NULL,
  `bolum_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ogrenci_id`),
  KEY `bolum_id` (`bolum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `ogrenciler`
--

INSERT INTO `ogrenciler` (`ogrenci_id`, `ogrenci_ad_soyad`, `ogrenci_no`, `bolum_id`) VALUES
(23, 'Osman Karadeniz', '190542012', 15);

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `bolumler`
--
ALTER TABLE `bolumler`
  ADD CONSTRAINT `bolumler_ibfk_1` FOREIGN KEY (`fakulte_id`) REFERENCES `fakulteler` (`fakulte_id`);

--
-- Tablo kısıtlamaları `kitaplar`
--
ALTER TABLE `kitaplar`
  ADD CONSTRAINT `kitaplar_ibfk_1` FOREIGN KEY (`kitap_turleri_id`) REFERENCES `kitap_turleri` (`kitap_turleri_id`);

--
-- Tablo kısıtlamaları `ogrenciler`
--
ALTER TABLE `ogrenciler`
  ADD CONSTRAINT `ogrenciler_ibfk_1` FOREIGN KEY (`bolum_id`) REFERENCES `bolumler` (`bolum_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
