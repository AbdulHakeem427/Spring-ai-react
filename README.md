
🌱 # Spring AI - Ask AI & Recipe Generator


A simple Spring Boot + React application integrating Spring AI with Ollama to:

Ask general knowledge questions

Generate customized recipes using AI based on ingredients, cuisine, and dietary preferences


![Screenshot 2025-06-20 194732](https://github.com/user-attachments/assets/6114ba86-6a2f-4741-9c1c-fc99cc22b298)
![Screenshot 2025-06-20 194806](https://github.com/user-attachments/assets/31b55d59-f5a6-4bea-a5de-9dbdebee0a8e)
![Screenshot 2025-06-20 193545](https://github.com/user-attachments/assets/99c8bbc0-e444-4c3e-b5a0-e152cff0bfe4)


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

