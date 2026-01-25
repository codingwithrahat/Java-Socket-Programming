# Multi Client Chat System

This is a **multi-client chat system** implemented using **Java Socket Programming**.  
The server can handle **multiple clients simultaneously** using **threads**, so all clients can chat independently without blocking each other.  

Clients can communicate over a **Local Area Network (LAN)** without internet.

---

## How It Works

- The **Server** listens on a port (default: `5000`).
- Each **Client** connects to the server using the server’s IP address.
- Messages sent by a client are **broadcast** to all other connected clients.
- All clients must be on the **same LAN** to chat.

---

## How to Run (CMD)

1. Open **Command Prompt** and navigate to the folder containing the `.java` files.

2. Compile the Java programs:  
   javac Server.java   (for Server PC)  
   javac Client.java   (for Client PC)  

3. Run the Server:  
   java Server

4. Run each Client (on the same PC or different PCs in the same LAN):  
   java Client

5. Make sure to **run the server first**, then start the client(s).

**Note for Single PC Users:**  
- You can open **multiple Command Prompt windows** on the same PC.  
- Run the server in one window.  
- Run each client in a **separate window**.  
- This way, every client acts like an independent machine and can chat with each other.

**Important:** If running clients on different PCs, replace `localhost` in the client code with the **server PC's LAN IP**.

