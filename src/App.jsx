import React, { useState } from 'react'
import ChatComponent from './components/ChatComponent'
import RecipeComponent from './components/RecipeComponent'

function App() {
  const [activeTab, setActiveTab] = useState('chat')

  const handleTabChange = (tab) => {
    setActiveTab(tab)
  }

  return (
    <div className="min-h-screen bg-gray-100 p-4">
      <div className="flex justify-center gap-4 mb-6">
        <button
          className={`px-4 py-2 rounded ${
            activeTab === 'chat' ? 'bg-blue-500 text-white' : 'bg-white text-blue-500 border border-blue-500'
          }`}
          onClick={() => handleTabChange('chat')}
        >
          Ask AI
        </button>
        <button
          className={`px-4 py-2 rounded ${
            activeTab === 'recipe-generator' ? 'bg-green-500 text-white' : 'bg-white text-green-500 border border-green-500'
          }`}
          onClick={() => handleTabChange('recipe-generator')}
        >
          Recipe Generator
        </button>
      </div>

      <div className="max-w-2xl mx-auto bg-white shadow-md p-6 rounded-lg">
        {activeTab === 'chat' && <ChatComponent />}
        {activeTab === 'recipe-generator' && <RecipeComponent />}
      </div>
    </div>
  )
}

export default App
