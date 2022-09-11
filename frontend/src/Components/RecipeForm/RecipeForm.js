import { useRef } from "react"
import { useState } from "react"
import { useFetch } from "../../hooks/useFetch"
import { Link } from "react-router-dom"


//styles
import './RecipeForm.css'
import { useEffect } from "react"

export default function RecipeForm({ addRecipe }) {

    const [title, setTitle] = useState('')
    const [ingredients, setIngredients] = useState([])
    const [instructions, setInstructions] = useState('')
    const [newIngredient, setNewIngredient] = useState('')
    const ingredientInput = useRef(null)
    // const history = useHistory()

    const { postData, data, error } = useFetch("http://localhost:3000/recipes", "POST")

    const resetForm = () => {
        setTitle('')
        setIngredients([])
        setInstructions('')
        setNewIngredient('')
    }

    //saving to json server will auto generate unique id
    const handleSubmit = (e) => {
        e.preventDefault()
        postData({ title, ingredients, instructions })
        resetForm()
    }

    //original for testing 
    // const handleSubmit = (e) => {
    //     e.preventDefault()
    //     const event = {
    //         title: title,
    //         ingredients: ingredients,
    //         instructions: instructions,
    //         id: Math.floor(Math.random() * 10000)
    //     }
    //     console.log(event)
    //     // addRecipe(event)
    //     resetForm()
    // }

    const handleAdd = (e) => {
        e.preventDefault()
        const ing = newIngredient.trim()

        if (ing && !ingredients.includes(ing)) {
            setIngredients(prevIngredients => [...prevIngredients, ing])
        }
        setNewIngredient('')
        ingredientInput.current.focus()
    }


    // const List = ({ list }) => (
    //     // <ul>
    //     //     {ingredients.map((item) => (
    //     //         <li key={item.id}>{item.name}</li>
    //     //     ))}
    //     // </ul>
    // );



    const ingredientList = ingredients.map((ingredient) => {
        return (
            <ul>
                <li key={ingredient}>{ingredient}</li>
            </ul>
        )
    })


    // instead we will use inline functions to update individual state
    //     const handleChange = (e) => {
    //         console.log(e.target.value)
    //         setTitle(e.target.value)
    //     }

    //after we recieve data response redirect to recipes page
    // useEffect(() => {
    //     if (data) {
    //         history.push('/recipes')
    //     }
    // }, [data])

    return (

        <form className="recipeform" onSubmit={handleSubmit}>

            <h2 className="recipeform-heading">New Recipe</h2>

            <div className="recipeform-section">

                <div className="recipeform-row">
                    <label for="recipe-title" />
                    <input
                        type="text"
                        id="recipe-title"
                        name='title'
                        placeholder='Recipe Title'
                        onChange={(e) => setTitle(e.target.value)}
                        value={title}
                    />
                </div>

                <div className="recipeform-row">

                    <div className="ingredients">
                        <label for="recipe-ingredients" />
                        <input
                            type="text"
                            id="recipe-ingredients"
                            name='ingredients'
                            placeholder='Ingredients'
                            onChange={(e) => setNewIngredient(e.target.value)}
                            value={newIngredient}
                            ref={ingredientInput}
                        />
                        <label for="ingredient quantity" />
                        <input
                            type="number"
                            id="ingredient-quantity"
                            name="ingredient-quantity"
                            placeholder="Qty"
                            min={0}
                        // onChange={(e) => setQuantity(e.target.value)}
                        />
                        <input
                            type="text"
                            id="ingredient-measurement"
                            name="ingredient-measurement"
                            placeholder="Unit"
                            list="units"
                        // onChange={(e) => setQuantity(e.target.value)}
                        />
                        <datalist id="units">
                            <option>tbsp.</option>
                            <option>tsp.</option>
                            <option>cup</option>
                            <option>pint</option>
                        </datalist>
                        <img src="plussign.png" className="add-ingredient-img" onClick={handleAdd} />

                        {/* <button className="add-ingredient-btn" onClick={handleAdd} >Add</button> */}
                    </div>
                    {ingredientList}
                </div>

                <div className="recipeform-time-container">

                    <div className="recipeform-row">
                        <fieldset>
                            <legend>Prep time</legend>
                            <div className="time">
                                <label for="prep-time-hrs" />
                                <input
                                    type="number"
                                    id="prep-time-hrs"
                                    placeholder="Hrs"
                                    min={0}
                                // onChange={(e) => setPrepHrs(e.target.value)}
                                />
                            </div>
                            <div className="time">
                                <label for="prep-time-mins">
                                    <input
                                        type="number"
                                        id="prep-time-mins"
                                        name="prep-mins"
                                        placeholder="Mins"
                                        min={0}
                                    // onChange={(e) => setPrepMins(e.target.value)}
                                    />
                                </label>
                            </div>
                        </fieldset>
                    </div>

                    <div className="recipeform-row">
                        <fieldset>
                            <legend>Cook time</legend>
                            <div className="time">

                                <label for="cook-time-hrs">
                                    <input
                                        type="number"
                                        id='cook-time-hrs'
                                        placeholder="Hrs"
                                        min={0}
                                    // onChange={(e) => setCookHrs(e.target.value)}

                                    />
                                </label>
                            </div>
                            <div className="time">
                                <label for="cook-time-mins">
                                    <input
                                        type="number"
                                        id='cook-time-mins'
                                        placeholder="Mins"
                                        min={0}
                                    // onChange={(e) => setCookMins(e.target.value)}                               
                                    />
                                </label>
                            </div>
                        </fieldset>
                    </div>

                </div>
            </div>

            <div className="recipeform-section">

                <label for="instructions" />
                <span>Instructions</span>
                <input
                    type="text"
                    id="instructions"
                    name='instructions'
                    placeholder='Instructions'
                    onChange={(e) => setInstructions(e.target.value)}
                    value={instructions}
                />

                <p>sanity check:</p>
                <p>title - {title}</p>
                <p>new ingredient - {newIngredient}</p>
                <p>all ingredients - {ingredients}</p>
                <p>instructions - {instructions}</p>
                {/* button will inherit onSubmit from form */}
                <button onClick={handleSubmit}>Add Recipe</button>
                <Link to="/recipes">
                    <button>Go Back to Recipes</button>
                </Link>
            </div>

        </form>
    )
}

