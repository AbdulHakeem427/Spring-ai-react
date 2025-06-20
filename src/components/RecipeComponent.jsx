import React, { useState } from 'react'

function RecipeComponent() {
  const [ingredients, setIngredients] = useState('')
  const [cuisine, setCuisine] = useState('any')
  const [dietaryRestrictions, setDietaryRestrictions] = useState('')
  const [recipe, setRecipe] = useState('')
  const [loading, setLoading] = useState(false)

  const createRecipe = async () => {
    setLoading(true)
    setRecipe('') // Clear previous
    try {
      const response = await fetch(
        `http://localhost:8080/recipe-creator?ingredients=${ingredients}&dietaryRestrictions=${dietaryRestrictions}&cuisine=${cuisine}`
      )
      const data = await response.text()
      setRecipe(data)
    } catch (error) {
      setRecipe('Error generating recipe.')
      console.log('Error generating response', error)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div>
      <h2 className="text-2xl font-bold mb-4 text-green-700">Recipe Generator</h2>

      <input
        type="text"
        value={ingredients}
        onChange={(e) => setIngredients(e.target.value)}
        placeholder="Ingredients (comma separated)"
        className="w-full border border-gray-300 rounded px-4 py-2 mb-2"
      />
      <input
        type="text"
        value={cuisine}
        onChange={(e) => setCuisine(e.target.value)}
        placeholder="Cuisine"
        className="w-full border border-gray-300 rounded px-4 py-2 mb-2"
      />
      <input
        type="text"
        value={dietaryRestrictions}
        onChange={(e) => setDietaryRestrictions(e.target.value)}
        placeholder="Dietary Restrictions"
        className="w-full border border-gray-300 rounded px-4 py-2 mb-4"
      />

      <button
        onClick={createRecipe}
        className="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600"
        disabled={loading}
      >
        {loading ? 'Loading...' : 'Create Recipe'}
      </button>

      <div className="mt-4 bg-gray-100 p-4 rounded shadow min-h-[100px]">
        {loading ? (
          <p className="text-gray-500">Generating recipe...</p>
        ) : (
          <pre className="whitespace-pre-wrap">{recipe}</pre>
        )}
      </div>
    </div>
  )
}

export default RecipeComponent
