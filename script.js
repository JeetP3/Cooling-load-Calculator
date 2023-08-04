document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('cooling-load-form');
    const resultsContainer = document.getElementById('results');
    const coolingLoadElement = document.getElementById('cooling-load');
    const conductionElement = document.getElementById('conduction');
    const sensibleCoolingLoadElement = document.getElementById('sensible-cooling-load');

    const calculateBtn = document.getElementById('calculate-btn');
    calculateBtn.addEventListener('click', function () {
        const area = parseFloat(document.getElementById('area').value);
        const occupants = parseInt(document.getElementById('occupants').value);
        const buildingType = document.getElementById('building-type').value;
        const outdoorTemp = parseFloat(document.getElementById('outdoor-temp').value);
        const indoorTemp = parseFloat(document.getElementById('indoor-temp').value);

        let coolingLoad;
        if (buildingType === 'residential') {
            coolingLoad = 100 * occupants;
        } else if (buildingType === 'commercial') {
            coolingLoad = 150 * occupants;
        } else {
            coolingLoad = 0;
        }

        const u = 30; // Overall heat transfer coefficient in W/m²°C
        const qConduction = u * area * (outdoorTemp - indoorTemp);
        const sensibleCoolingLoad = qConduction + coolingLoad;

        coolingLoadElement.textContent = `Cooling Load: ${coolingLoad.toFixed(2)} W`;
        conductionElement.textContent = `Heat Transfer due to Conduction: ${qConduction.toFixed(2)} W`;
        sensibleCoolingLoadElement.textContent = `Sensible Cooling Load: ${sensibleCoolingLoad.toFixed(2)} W`;

        resultsContainer.classList.remove('hidden');
    });
});
