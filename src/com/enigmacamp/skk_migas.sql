create table pelanggan (
	kode varchar(11) primary key,
	nama varchar(255),
	alamat varchar(255)
);

create table barang (
	kode varchar(11) primary key,
	nama varchar(255),
	harga numeric(255,0)
);

create table transaksi (
	kode varchar(11) primary key,
	tanggal date,
	kode_pelanggan varchar(11),
	kode_barang varchar(11),
	jumlah_barang numeric(255,0),
	foreign key(kode_pelanggan) references pelanggan(kode),
	foreign key(kode_barang) references barang(kode)
);


insert into barang values
('B1', 'Baju', 12000),
('B2', 'Celana', 10000),
('B3', 'Sepatu', 30000);

insert into pelanggan values
('P1', 'Yogi', 'JAKARTA'),
('P2', 'Anggi', 'BANDUNG'),
('P3', 'Rahma', 'BANDUNG');

insert into transaksi values
('TRX001', '2019-10-01', 'P1', 'B1', '3'),
('TRX002', '2019-10-02', 'P2', 'B2', '2'),
('TRX003', '2019-10-08', 'P2', 'B1', '5'),
('TRX004', '2019-10-10', 'P1', 'B1', '1'),
('TRX005', '2019-10-17', 'P3', 'B2', '2'),
('TRX006', '2019-10-17', 'P2', 'B3', '1'),
('TRX007', '2019-10-18', 'P3', 'B1', '4'),
('TRX008', '2019-10-18', 'P2', 'B2', '2');


-- 4a
SELECT
kode, nama, harga
FROM barang WHERE harga > 10000 ORDER BY harga ASC;

-- 4b
SELECT
nama, alamat
FROM pelanggan WHERE alamat = 'BANDUNG' AND nama ILIKE '%g%';

--4c
SELECT
t.kode, t.tanggal, p.nama, b.nama, t.jumlah_barang as jumlah, b.harga as harga_satuan, t.jumlah_barang * b.harga as total 
FROM transaksi t
JOIN pelanggan p ON p.kode = t.kode_pelanggan
JOIN barang b ON b.kode = t.kode_barang ORDER BY p.nama;

--4d
SELECT
p.nama, SUM(t.jumlah_barang) as jumlah, SUM(t.jumlah_barang * b.harga) as total 
FROM transaksi t
JOIN pelanggan p ON p.kode = t.kode_pelanggan
JOIN barang b ON b.kode = t.kode_barang
GROUP BY p.nama ORDER BY p.nama ASC;