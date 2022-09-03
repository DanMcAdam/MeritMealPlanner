// import styles from './RecipesListView.css'
//styles
import './RecipesListView.css'


export default function RecipesListView({ events, handleClick }) {

    // fetch(' http://localhost:3000/recipes')
    //     .then(response => response.json())
    //     .then(json => console.log(json))

    // managing recipe state in Recipes so moved this over there
    // useEffect(() => {
    //     fetch(' http://localhost:3000/recipes')
    //         .then(response => response.json())
    //         .then(json => setRecipeCollection(json))
    // }, [])

    return (
        <div className='recipe-list-container'>
            {events.map((event, index) => (
                <div className='recipe-list-item' key={event.id}>
                    <h2>{index} - {event.title}</h2>
                    <button onClick={() => handleClick(event.id)}>delete event</button>
                </div>
            ))}
        </div>
    )
}
