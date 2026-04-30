import socket

PORT = 5001

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind(("100.98.227.34", PORT))

print(f"Server UDP pornit pe portul {PORT}. Aștept mesaje...")

while True:
    data, addr = sock.recvfrom(1024)

    mesaj = data.decode('utf-8').strip()
    print(f"Client: {mesaj}")

    if mesaj.lower() == "exit":
        break

    raspuns = input("Server: ")

    sock.sendto(raspuns.encode('utf-8'), addr)

    if raspuns.lower() == "exit":
        break

sock.close()