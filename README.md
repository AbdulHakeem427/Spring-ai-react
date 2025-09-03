
🌱 # SmartChef AI - Ask AI & Recipe Generator


![WhatsApp Image 2025-09-03 at 11 33 28 AM](https://github.com/user-attachments/assets/330098da-330a-40ec-8846-cd5689e6ca5a)
![WhatsApp Image 2025-09-03 at 11 33 28 AM](https://github.com/user-attachments/assets/285dd01b-1b86-45b0-bc58-e0cae753ffc1)

A simple Spring Boot + React application integrating Spring AI with Ollama to:

Ask general knowledge questions

Generate customized recipes using AI based on ingredients, cuisine, and dietary preferences



# 💬 AI-Powered Assistant with Recipe Generator & Image Creation

This full-stack application enables users to:
- Ask any general question to an AI assistant.
- Generate cooking recipes based on selected ingredients, cuisine types, and dietary preferences.
- Generate AI-powered images based on user prompts.

Built using **Spring Boot**, **ReactJS**, and **Ollama** AI model integrations.

---

## 🧩 Features

### 🔹 Chat with AI
- Asks general questions to an AI assistant.
- Processes and cleans AI responses to remove internal tags like `<think>`.

### 🔹 Recipe Generator
- Suggests recipes based on ingredients, cuisine type, and dietary restrictions.
- Output is formatted as a proper recipe with title, ingredients, and step-by-step instructions.

### 🔹 AI Image Generator
- Accepts a prompt and returns URLs of AI-generated images.

---

## ⚙️ Tech Stack

| Frontend              | Backend             | AI & Tools           |
|-----------------------|----------------|----------------------|
| React + TailwindCSS   | Spring Boot (Java)  | Spring AI + Ollama   |
| Fetch API             | RESTful APIs        | Prompt Templates     |
| Vite                  | Chat & Image Models | Swagger Annotations  |





#### Key Endpoints:


- `GET /ask-ai?prompt=...`
- `GET /recipe-creator?ingredients=...&cuisine=...&dietaryRestriction=...`
- `GET /generate-image?prompt=...`

### 💻 Frontend (React + Vite)

1. Navigate to `frontend/` folder.
2. Install dependencies:
   ```bash
   npm install
3. Run the app:
   npm run dev
App runs on:
 http://localhost:5173

###🙌 Acknowledgements
Spring AI
Ollama
Tailwind CSS

