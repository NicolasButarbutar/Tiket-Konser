# 🎫 Mini Project: EventSwift Ticket System

## 📖 Definisi Proyek

EventSwift Ticket System adalah aplikasi pemesanan tiket konser otomatis yang dirancang untuk mengelola transaksi dengan cepat dan efisien. Aplikasi ini berfokus pada alur pemesanan yang dinamis, mulai dari pemilihan kategori tiket hingga simulasi pembayaran yang aman. Sistem ini memanfaatkan prinsip Object-Oriented Programming untuk memastikan alur kerja pemesanan tetap modular, aman, dan mudah dipelihara.

## 🛠️ Implementasi Materi Object-Oriented Programming
Berdasarkan materi perkuliahan *Nested Constructs* dan *Records*, proyek ini mengintegrasikan konsep-konsep berikut:

### 1. Java Records (Data Integrity)
- **Immutable Data**: `Ticket` dideklarasikan sebagai `record` karena informasi dasar tiket (nama acara, kategori, dan harga) bersifat tetap dan tidak boleh diubah setelah inisialisasi.
- **Boilerplate Reduction**: Memanfaatkan `record` untuk menghilangkan kode *boilerplate* seperti konstruktor, *accessor*, dan `toString()`, membuat model data lebih bersih.

### 2. Local Classes (Encapsulation of Logic)
- **Scoping**: `PriceCalculator` didefinisikan sebagai *Local Class* di dalam metode `processBooking`. Logika ini hanya relevan saat proses *checkout* berlangsung, sehingga tidak perlu mengekspos kelas tersebut di luar cakupan metode.
- **Efficiency**: Membatasi visibilitas kelas hanya pada tempat ia dibutuhkan (*tight scoping*).

### 3. Anonymous Classes (Dynamic Behavior)
- **Dynamic Interface Implementation**: *Interface* `PaymentGateway` diimplementasikan secara langsung menggunakan *Anonymous Class* saat proses pembayaran.
- **Contextual Behavior**: Memungkinkan penentuan perilaku pembayaran (QRIS atau Cash) secara *runtime* tanpa perlu membuat banyak *concrete class* yang tidak efisien.

## 📂 Struktur Proyek
Sesuai dengan pengorganisasian paket yang kohesif pada materi perkuliahan:

```text
src/
├── driver/
│   └── TicketDriver.java      # Main logic, Scanner, Local & Anonymous Classes
└── model/
    └── Ticket.java            # Record struktur data Tiket
```

## 💻 Simulasi Input & Output
Skenario: Pembelian Tiket Konser

```
=== Selamat Datang di THE WEEKND LIVE IN JAKARTA 2026 ===
Venue: Gelora Bung Karno Stadium
Pilih Kategori: 1. Reguler (500rb) | 2. VIP (1.5jt) | 3. VVIP (3jt)
Pilihan Anda: 3

Metode Pembayaran: 1. QRIS | 2. Cash
Pilihan: 1

========================================
       E-TICKET KONSER BERHASIL
========================================
Event    : THE WEEKND LIVE IN JAKARTA 2026
Venue    : Gelora Bung Karno Stadium
Kategori : VVIP
Tanggal  : 2026-04-25
Total    : Rp2400000.0
Status   : LUNAS via QRIS
ID Tiket : 849201
========================================
```

## ⚖️ Standar Penilaian Konser (Diskon)
Sistem secara otomatis menerapkan diskon berdasarkan kategori tiket yang dipilih:

- **VVIP: Diskon 20%

- **VIP/Reguler: Diskon 5%

## 📝 Referensi Materi
- **Simaremare, Mario. 11-01-Nested Constructs. Program Studi Sarjana Sistem Informasi, Institut Teknologi Del.
- **imaremare, Mario. 11-03-Record. Program Studi Sarjana Sistem Informasi, Institut Teknologi Del.