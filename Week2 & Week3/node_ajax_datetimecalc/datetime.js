const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

function taskRoute(datestr, option, n=0) {
    n = parseInt(n)
    let sp = datestr.split("-");
    let date = new Date(sp[0], sp[1] - 1, sp[2]);
    switch (option) {
        case "Tomorrow": return addDays(date, 1);
        case "Yesterday": return minusDays(date, 1);
        case "N months earlier": return minusMonths(date, n);
        case "N years earlier": return minusYears(date, n);
        case "Date N weeks later": return addWeeks(date, n);
        case "Date N months later": return addMonths(date, n);
        case "Date Next Week": return addWeeks(date, 1);
        case "Day after tomorrow": return addDays(date, 2);
        case "Day before yesterday": return minusDays(date, 2);
        case "Add N days": return addDays(date, n);
        case "Add N months": return addMonths(date, n);
        case "Add N Weeks": return addWeeks(date, n);
        case "Add N years": return addYears(date, n);
        case "Minus N days": return minusDays(date, n);
        case "Date N years later": return addYears(date, n);
        case "Date Last Week": return minusWeeks(date, 1);
        case "Date Last month": return minusMonths(date, 1);
        case "Date Last year": return minusYears(date, 1);
        case "Minus N months": return minusMonths(date, n);
        case "Minus N Weeks": return minusWeeks(date, n);
        case "Minus N years": return minusYears(date, n);
        case "Day of the week": return getDayOfTheWeek(date);
        case "N weeks earlier": return minusWeeks(date, n);
        case "Date Next month": return addMonths(date, 1);
        case "Date Next year": return addYears(date, 1);
        default: return new Date();
    }
}

let getDayOfTheWeek = date => days[date.getDay()]

let addDays = (date, days) => new Date(date.setDate(date.getDate() + days))

let addWeeks = (date, days=days*7) => new Date (date.setDate(date.getDate() + days))

let addMonths = (date, months) => new Date(date.setMonth(date.getMonth()+months))

let addYears = (date, years) => new Date(date.setFullYear(date.getFullYear() + years))

let minusDays = (date, days) => new Date(date.setDate(date.getDate() - days))

let minusWeeks = (date, days=days*7) => new Date(date.setDate(date.getDate() - days))

let minusMonths = (date, months) => new Date(date.setMonth(date.getMonth()- months))

let minusYears = (date, years) => new Date(date.setFullYear(date.getFullYear() - years))


module.exports = { taskRoute }