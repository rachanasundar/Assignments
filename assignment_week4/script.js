const comingSoonMovies = async() => {
    
    var previous = document.querySelector('.row');
    previous.remove();
    const addrow = document.querySelector('.container-fluid');
    addrow.innerHTML = `
    <div class ="search"> 
    <input type="text" name = "movieName" id="movieName" >  
    <input type="submit"  name = "submit" id = "submitButton" 
    onclick="searchMovie("http://localhost:3000/movies-coming")" > </input> 
    </div>

    <div class="row">
    <header> <h2>Movies Coming Soon</h2></header>
    
    </div`;
    display("http://localhost:3000/movies-coming");

    
}

const inTheatersMovies = async() => {
    var previous = document.querySelector('.row');
    previous.remove();
    const addrow = document.querySelector('.container-fluid');
    addrow.innerHTML = `
    <div class ="search"> 
    <input type="text" name = "movieName" id="movieName" >  
    <input type="submit"  name = "submit" id = "submitButton" 
    value = "Submit" onclick="searchMovie("http://localhost:3000/movies-in-theaters")" > 
    </div>
    <div class="row">
    <header> <h2>Movies In Theaters</h2></header>
    
    </div`;
    
    display("http://localhost:3000/movies-in-theaters")
    
}
const topRatedIndia = async() => {
    
    var previous = document.querySelector('.row');
    previous.remove();
    const addrow = document.querySelector('.container-fluid');
    addrow.innerHTML = `
    <div class ="search"> 
    <input type="text" name = "movieName" id="movieName" >  
    <input type="submit"  name = "submit" id = "submitButton" 
    value = "Submit" onclick="searchMovie("http://localhost:3000/top-rated-india")" > 
    </div>
    <div class="row">
    <header> <h2>Top Rated Indian Movies</h2></header>
    
    </div`;
    display("http://localhost:3000/top-rated-india")
  

    }

const topRatedMovies = async() => {
    
    var previous = document.querySelector('.row');
    previous.remove();
    const addrow = document.querySelector('.container-fluid');
    addrow.innerHTML = `
    <div class ="search"> 
    <input type="text" name = "movieName" id="movieName" >  
    <input type="submit"  name = "submit" id = "submitButton" 
    onclick="searchMovie(http://localhost:3000/top-rated-movies)" ></input> 
    </div>
    <div class="row">
    <header> <h2>Top Rated Movies</h2></header>
    
    </div`;
    display("http://localhost:3000/top-rated-movies")
   
}

const loadFavorite = async() => {
    var previous = document.querySelector('.row');
    previous.remove();
    const addrow = document.querySelector('.container-fluid');
    addrow.innerHTML = `
    <div class="row">
    <header> <h2>My Favorites</h2></header>`;
    
    let response = await fetch("http://localhost:3000/favourit")
    let data = await response.json();
    
    for (let i = 0; i < data.length; i++) {
        const movietable = document.querySelector('.row');
        movietable.innerHTML = movietable.innerHTML + `<div class="col-md-2 m-a-2">
<div class="card">
<img class="card-img-top img-fixed" src="${data[i].posterurl}" onerror="this.src='https://motivatevalmorgan.com/wp-content/uploads/2016/06/default-movie.jpg';" alt="Card image cap">
<ul class="list-group list-group-flush">
    <li class="list-group-item">Imdb Rating : ${data[i].imdbRating}</li>
            <li class="list-group-item">Year : ${data[i].year}</li>
            <li class="list-group-item">Release Date :${data[i].releaseDate}</li>
</ul>
<div class="card-block">
<button type="button" class="btn btn-primary btn-responsive" onclick="displayDetails('${data[i].id}', url );">Details</button>
    <button type="button" class="btn btn-primary btn-responsive1" onclick="removeItem('${data[i].id}','${data[i].title}','${data[i].posterurl}','${data[i].year}','${data[i].releaseDate}');">Remove</button>
</div>

</div>

</div>
`
    
    }    
}



const display = async(url)=>{

    let response = await fetch(url)
    let data = await response.json();
    
    for (let i = 0; i < data.length; i++) {
        const movietable = document.querySelector('.row');
        movietable.innerHTML = movietable.innerHTML + `<div class="col-md-2 m-a-2">
<div class="card">
<img class="card-img-top img-fixed" src="${data[i].posterurl}" onerror="this.src='https://motivatevalmorgan.com/wp-content/uploads/2016/06/default-movie.jpg';" alt="Card image cap">
<ul class="list-group list-group-flush">
    <li class="list-group-item">Imdb Rating : ${data[i].imdbRating}</li>
            <li class="list-group-item">Year : ${data[i].year}</li>
            <li class="list-group-item">Release Date :${data[i].releaseDate}</li>
</ul>
<div class="card-block">
<button type="button" class="btn btn-primary btn-responsive" onclick="displayDetails('${data[i].id}', url );">Details</button>
    <button type="button" class="btn btn-primary btn-responsive" onclick="add_to_favorite('${data[i].id}','${data[i].title}','${data[i].posterurl}','${data[i].year}','${data[i].releaseDate}');">Add to favorite</button>
</div>

</div>

</div>
`

}
}

function add_to_favorite(a, b, c, d, e) {
    alert(b + " Is added to My Favorite");
    fetch('http://localhost:3000/favourit', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, /',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                currentid: a,
                title: b,
                posterurl: c,
                year: d,
                releasedate: e
            })
        }).then(res => res.json())
        .then(res => console.log(res));
}
function removeItem(id){
    alert(id + " will be removed from my Favorite");
    fetch('http://localhost:3000/favourit/' +id,
    {
        method:"Delete"
    }).then(res => res.json())
        .then(res => console.log(res));

}


const searchMovie= async(url) => {
    let movie = document.getElementById('movieName').value
    if(movie.length ==0){
        alert("Please type the movie name");
    } 
    else{

        var previous = document.querySelector('.row');
        previous.remove();
        const addrow = document.querySelector('.container-fluid');
        addrow.innerHTML = ` <div class="row">
        <header> <h2>Result</h2></header>
        </div>`
        

    let response = await fetch(url)
    let data = await response.json();

    for(let i =0;i<data.length;i++ )
   { if (data[i].title==movie){
        const movietable = document.querySelector('.row');
        movietable.innerHTML = movietable.innerHTML + `<div class="col-md-2 m-a-2">
<div class="card">
<img class="card-img-top img-fixed" src="${data[i].posterurl}" onerror="this.src='https://motivatevalmorgan.com/wp-content/uploads/2016/06/default-movie.jpg';" alt="Card image cap">
<ul class="list-group list-group-flush">
    <li class="list-group-item">Imdb Rating : ${data[i].imdbRating}</li>
            <li class="list-group-item">Year : ${data[i].year}</li>
            <li class="list-group-item">Release Date :${data[i].releaseDate}</li>
</ul>
<div class="card-block">
<button type="button" class="btn btn-primary btn-responsive" onclick="displayDetails('${data[i].id}', url );">Details</button>
    <button type="button" class="btn btn-primary btn-responsive" onclick="add_to_favorite('${data[i].id}','${data[i].title}','${data[i].posterurl}','${data[i].year}','${data[i].releaseDate}');">Add to favorite</button>
    
</div>

</div>

</div>
`



    }} 
}
        
    
   
}

const displayDetails = async(id,url) => {
    var previous = document.querySelector('.row');
    previous.remove();
    const addrow = document.querySelector('.container-fluid');
    addrow.innerHTML = ` <div class="row">
    <header> <h2> About Movie </h2></header>
    </div>`

    let response = await fetch(url)
    let data = await response.json();
    let divTag = document.getElementById("obj");

    for(let i =0;i<data.length;i++ ){
    if (data[i].id ==id){
        var pTag = document.createElement("p");
        var pId = document.createTextNode(data[i].id);
        var pTitle= document.createTextNode(data[i].title)
        var pYear =document.createTextNode(data[i].year)
        var pGenre =document.createTextNode(data[i].genres)
        var pRatings = document.createTextNode(data[i].ratings)
        var pcontentRating =document.createTextNode(data[i].contentRating)
        var pduration = document.createTextNode(data[i].duration);
        var preleaseDate = document.createTextNode(data[i].releaseDate);
        var paverageRating = document.createTextNode(data[i].averageRating);
        var poriginalTitle = document.createTextNode(data[i].originalTitle);
        var pstoryline = document.createTextNode(data[i].storyline);
        var pactors = document.createTextNode(data[i].actors);
        var pimdbRating = document.createTextNode(data[i].imdbRating);
        var imgposterurl = document.ccreateElement("img");
        pposterurl.setAttribute("src",data[i].posterurl);
        pPoster.setAttribute("width","20px");
        pPoster.setAttribute("height","20px");
        var imgPoster= document.createElement("img");
        pPoster.setAttribute("src",data[i].poster);
        pPoster.setAttribute("width","20px");
        pPoster.setAttribute("height","20px");

        pTag.appendChild(pId);
        pTag.appendChild(pTitle);
        pTag.appendChild(pYear);
        pTag.appendChild(pGenre);
        pTag.appendChild(pRatings);
        pTag.appendChild(pcontentRating);
        pTag.appendChild(pduration);
        pTag.appendChild(preleaseDate);
        pTag.appendChild(paverageRating);
        pTag.appendChild(poriginalTitle);
        pTag.appendChild(pstoryline);
        pTag.appendChild(pactors);
        pTag.appendChild(pimdbRating);
        divTag.appendChild(pTag);
        divTag.appendChild(imgPoster);
        divTag.appendChild(imgposterurl);

    } 

    }

}



