Rule 1: Eligible Rules (Touch Many Processing Workflows)
================================================================
Member:
pregnant=true
clockScheduled=true
age = 23
houseHoldIncome = 9000

o Stale
-------------------------------

o Inelibility Prechecks
-------------------------------
- Income >= 500000
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Incometype Determination
-------------------------------
- New Born
setIncomeType("CHIP")

o Medicaid FPL Level Determination
-------------------------------
- incomeType == "CHIP" && houseHoldIncome < 15000
setFplComparedToMedicaidLevel(true)	

- incomeType == "CHIP" && houseHoldIncome >= 15000
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

- Anyone houseHoldIncome >= 5000 && houseHoldIncome < 15000 
setFplComparedToMedicaidLevel(true)	
***->Fired/Executed

- Anyone houseHoldIncome >= 15000 && houseHoldIncome <= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

- Anyone houseHoldIncome >= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Check Income Reasonable Compatability
-------------------------------
- newBorn == true && houseHoldIncome >= 15000
setNonCapabitibleIndicator(false);
* Ineligible, with reason:
setReason("Newborn HouseHold Income Incompatability");

- newBorn == true && houseHoldIncome < 15000
setNonCapabitibleIndicator(true);
***->Fired/Executed

- houseHoldIncome < 10000
setNonCapabitibleIndicator(true);

- clockScheduled 
***->Fired/Executed

- pregnant
***->Fired/Executed

o Eligible
-------------------------------
* Ineligible, with reason:
setReason("Eligible");

o Determine Coverage Code
-------------------------------
* Eligible, add code to reason:
setReason(getReason() + "Coverage: MEDCVRG02");
***->Fired/Executed

o Determine Aid Coverage
-------------------------------
* Eligible, add coverage to reason:
setReason(getReason() + " - Received Aid: BlueCross BlueShield");
***->Fired/Executed

o PostProcessing
-------------------------------
- Used for logging to console
***->Fired/Executed



Rule 2: Pending Eligibility
================================================================
Member:
age = 0
houseHoldIncome = 12000

o Stale
-------------------------------

o Inelibility Prechecks
-------------------------------
- Income >= 500000
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Incometype Determination
-------------------------------
- New Born
setIncomeType("CHIP")
***->Fired/Executed

o Medicaid FPL Level Determination
-------------------------------
- incomeType == "CHIP" && houseHoldIncome < 15000
setFplComparedToMedicaidLevel(true)	
***->Fired/Executed

- incomeType == "CHIP" && houseHoldIncome >= 15000
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

- Anyone houseHoldIncome >= 5000 && houseHoldIncome < 15000 
setFplComparedToMedicaidLevel(true)	

- Anyone houseHoldIncome >= 15000 && houseHoldIncome <= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

- Anyone houseHoldIncome >= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Check Income Reasonable Compatability
-------------------------------
- newBorn == true && houseHoldIncome >= 15000
setNonCapabitibleIndicator(false);
* Ineligible, with reason:
setReason("Newborn HouseHold Income Incompatability");

- newBorn == true && houseHoldIncome < 15000
setNonCapabitibleIndicator(true);
***->Fired/Executed

- houseHoldIncome < 10000
setNonCapabitibleIndicator(true);

o clockScheduled 
-------------------------------

o pregnant
-------------------------------

o Pending
-------------------------------
* Ineligible, with reason:
setReason("Pending Eligibility Review");
***->Fired/Executed

o PostProcessing
-------------------------------
- Used for logging to console
***->Fired/Executed


Rule 3: Non Compatible Income
================================================================
Member:
age = 23
houseHoldIncome = 10000

o Stale
-------------------------------

o Inelibility Prechecks
-------------------------------
- Income >= 500000
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Incometype Determination
-------------------------------
- New Born
setIncomeType("CHIP")

o Medicaid FPL Level Determination
-------------------------------
- incomeType == "CHIP" && houseHoldIncome < 15000
setFplComparedToMedicaidLevel(true)	

- incomeType == "CHIP" && houseHoldIncome >= 15000
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

- Anyone houseHoldIncome >= 5000 && houseHoldIncome < 15000 
setFplComparedToMedicaidLevel(true)	
***->Fired/Executed

- Anyone houseHoldIncome >= 15000 && houseHoldIncome <= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

- Anyone houseHoldIncome >= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Check Income Reasonable Compatability
-------------------------------
- newBorn == true && houseHoldIncome >= 15000
setNonCapabitibleIndicator(false);
* Ineligible, with reason:
setReason("Newborn HouseHold Income Incompatability");

- newBorn == true && houseHoldIncome < 15000
setNonCapabitibleIndicator(true);

- houseHoldIncome < 10000
setNonCapabitibleIndicator(true);

- default is 
setNonCapabitibleIndicator(false);
***->Fired/Executed

o Ineligible
-------------------------------
if (stale)
	* Ineligible, with reason:
	setReason("Is Stale");

o PostProcessing
-------------------------------
- Used for logging to console


Rule 4: FPL Level Determination Ineligible
================================================================
Member:
age = 55
houseHoldIncome = 17000

o Stale
-------------------------------

o Inelibility Prechecks
-------------------------------
- Income >= 500000
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Incometype Determination
-------------------------------
- New Born
setIncomeType("CHIP")

o Medicaid FPL Level Determination
-------------------------------
- incomeType == "CHIP" && houseHoldIncome < 15000
setFplComparedToMedicaidLevel(true)	

- incomeType == "CHIP" && houseHoldIncome >= 15000
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

- Anyone houseHoldIncome >= 5000 && houseHoldIncome < 15000 
setFplComparedToMedicaidLevel(true)	

- Anyone houseHoldIncome >= 15000 && houseHoldIncome <= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");
***->Fired/Executed

- Anyone houseHoldIncome >= 25000  
setFplComparedToMedicaidLevel(false)	
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");

o Ineligible
-------------------------------
if (stale)
	* Ineligible, with reason:
	setReason("Is Stale");

o PostProcessing
-------------------------------
- Used for logging to console
***->Fired/Executed


Rule 5: Inelibility Prechecks
================================================================
Member:
age = 55
houseHoldIncome = 55000

o Stale
-------------------------------

o Inelibility Prechecks
-------------------------------
- Income >= 500000
* Ineligible, with reason:
setReason("HouseHold Income Over Limit");
***->Fired/Executed

o Ineligible
-------------------------------
if (stale)
	* Ineligible, with reason:
	setReason("Is Stale");

o PostProcessing
-------------------------------
- Used for logging to console
***->Fired/Executed


Rule 6: Stale
================================================================
Member:
age = 55
houseHoldIncome = 55000

o Stale
-------------------------------
***->Fired/Executed

[Ineligible]
if (stale)
	* Ineligible, with reason:
	setReason("Is Stale");

o PostProcessing
-------------------------------
- Used for logging to console
***->Fired/Executed

