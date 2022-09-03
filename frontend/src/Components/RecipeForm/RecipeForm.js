import { useState } from "react"

//styles
import './RecipeForm.css'

export default function RecipeForm({ addRecipe }) {

    const [title, setTitle] = useState('')
    const [ingredients, setIngredients] = useState([])
    const [instructions, setInstructions] = useState('')

    const resetForm = () => {
        setTitle('')
        setIngredients([])
        setInstructions('')
    }

    const handleSubmit = (e) => {
        e.preventDefault()

        const event = {
            title: title,
            ingredients: ingredients,
            instructions: instructions,
            id: Math.floor(Math.random() * 10000)
        }
        console.log(event)
        addRecipe(event)
        resetForm()
    }

    // // instead we will use inline functions to update individual state
    //     const handleChange = (e) => {
    //         console.log(e.target.value)
    //         setTitle(e.target.value)
    //     }

    return (
        // <form className="new-recipe-form">
        //     {/* <label htmlFor="title">Event Title:</label>
        // <input type="text" id="title" /> */}
        //     <label>
        //         <span>Event Title:</span>
        //         <input type="text" />
        //     </label>
        //     <label>
        //         <span>Event Date:</span>
        //         <input type="date" />
        //     </label>
        //     <button>Submit</button>
        // </form>

        <form className="recipes-form" onSubmit={handleSubmit}>
            <h2 className="recipes-form_heading">New Recipe</h2>
            <div className="recipes-form_section">
                <label>
                    <input
                        type="text"
                        name='title'
                        placeholder='Name'
                        onChange={(e) => setTitle(e.target.value)}
                        value={title}
                    />
                </label>
                <label>
                    <input
                        type="text"
                        name='ingredients'
                        placeholder='Ingredients'
                        onChange={(e) => setIngredients(e.target.value)}
                        value={ingredients}
                    />
                </label>
                <label>
                    <input
                        type="text"
                        name='instructions'
                        placeholder='Instructions'
                        onChange={(e) => setInstructions(e.target.value)}
                        value={instructions}
                    />
                </label>
            </div>
            <p>title - {title}, ingredients - {ingredients}, instructions - {instructions}</p>
            {/* button will inherit onSubmit from form */}
            <button>Add Recipe</button>
        </form>

    )
}



{/* <form className="recipes-form">
    <h2 className="recipes-form_heading">New Recipe</h2>
    <div className="recipes-form_section">
        <input
            name='name'
            placeholder='Name'
        />
        <input
            name='ingredients'
            placeholder='Ingredients'
        />
        <input
            name='instructions'
            placeholder='Instructions'
        />

    </div>
</form> */}