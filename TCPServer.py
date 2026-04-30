import socket

PORT = 5000

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(("100.98.227.34", PORT))
server_socket.listen(1)

print("Server TCP pornit. Aștept conexiunea...")

conn, addr = server_socket.accept()
print("Conexiune stabilită.")

while True:
    data = conn.recv(1024).decode('utf-8').strip()
    if not data:
        break

    print(f"Client: {data}")

    if data.lower() == "exit":
        break

    raspuns = input("Server: ")

    conn.send((raspuns + "\n").encode('utf-8'))

    if raspuns.lower() == "exit":
        break

conn.close()
server_socket.close()