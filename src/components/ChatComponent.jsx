import React, { useState } from 'react'

function ChatComponent() {
  const [prompt, setPrompt] = useState('')
  const [chatResponse, setChatResponse] = useState('')
  const [loading, setLoading] = useState(false)

  const askAI = async () => {
    setLoading(true)
    setChatResponse('') // Clear previous
    try {
      const response = await fetch(`http://localhost:8080/ask-ai?prompt=${prompt}`)
      const data = await response.text()
      setChatResponse(data)
    } catch (error) {
      setChatResponse('Error fetching response.')
      console.log('Error ', error)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div>
      <h2 className="text-2xl font-bold mb-4 text-blue-700">Ask AI Anything</h2>
      <input
        type="text"
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
        placeholder="Enter your question..."
        className="w-full border border-gray-300 rounded px-4 py-2 mb-4"
      />
      <button
        onClick={askAI}
        className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        disabled={loading}
      >
        {loading ? 'Loading...' : 'Ask AI'}
      </button>

      <div className="mt-4 bg-gray-100 p-4 rounded shadow min-h-[100px]">
        {loading ? (
          <p className="text-gray-500">Loading response...</p>
        ) : (
          <p className="text-gray-800 whitespace-pre-wrap">{chatResponse}</p>
        )}
      </div>
    </div>
  )
}

export default ChatComponent
