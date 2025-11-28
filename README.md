# ⛓️ Blockchain Practice 1

Bộ bài tập này nhằm mục đích thực hành các kiến thức cơ bản về **Mã hóa (Cryptography)**, **Hàm băm (Hashing)**, **Merkle Tree**, và **SPV (Simplified Payment Verification)**, là những thành phần cốt lõi của Chuỗi khối (Blockchain) và Sổ cái phân tán (Distributed Ledger).

Chương trình được viết bằng **Java**.

---

## 🛠️ Hướng dẫn cơ bản

### 1. Chuẩn bị môi trường

Đảm bảo bạn đã cài đặt **Java Development Kit (JDK)** và thiết lập biến môi trường (PATH) để có thể chạy các lệnh `javac` và `java` từ terminal.

### 2. Tải mã nguồn

```bash
# Ví dụ nếu bạn dùng Git
git clone [ĐƯỜNG_DẪN_REPO_CỦA_BẠN]
cd [TÊN_THƯ_MỤC_DỰ_ÁN]

🔒 Bài 1: Mã hóa đối xứng đơn giản (XOR Cipher)

Mục đích

Chương trình thực hiện mã hóa và giải mã một chuỗi ký tự bất kỳ bằng XOR Cipher (Mã hóa đối xứng đơn giản nhất). Mỗi ký tự trong chuỗi được XOR với một khóa (là một số nguyên 1 byte từ 1 đến 255).
