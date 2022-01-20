let res;
const Breweries = async () => {
    res = await fetch('https://api.openbrewerydb.org/breweries?by_city=san_diego').then(res => res.json());
    console.log(res);
}

const showBreweries = async () => {

    await Breweries();

    //using maps instead of foreach

    let Breweries_names = res.map(res => res.name);
    console.log(Breweries_names);

    //using filter to get micro breweries

    let micro = res.filter(res => res.brewery_type === "micro");
    //console.log(micro);

    let arr;
    if (document.getElementById("all").checked) {
        arr = res;
    }
    else arr = micro;
    result = document.getElementById("res")
    result.innerHTML = "";
    arr.forEach(element => {
        let card_elem = document.createElement("div");
        card_elem.innerHTML = (
            `<div>
            <div class="col s12 m6">
                <div class="card blue-grey darken-1 card-panel hoverable">
                    <div class="card-content white-text">
                        <span class="card-title">${element.name}</span>
                        <p>Phone no : ${element.phone}</p>
                    </div>
                    <div class="card-action">
                        <a href="${element.website_url}">Visit our website</a>
                    </div>
                </div>
            </div>
        </div>`)
        result.appendChild(card_elem);
    });
    document.body.appendChild(result)



}

document.addEventListener('DOMContentLoaded', () => {
    showBreweries();
});