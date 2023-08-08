package com.example.medindicator.models

class Mock() {
    fun mockData() : List<Schedule> {
        val mockSchedule = mutableListOf<Schedule>()

        mockSchedule.add(
            Schedule(
                name = "Medication 1",
                time = "08:00 AM",
                duration = "1 week",
                dosage = "2 Pilulas"
            )
        )

        mockSchedule.add(
            Schedule(
                name = "Medication 2",
                time = "12:00 PM",
                duration = "2 weeks",
                dosage = "1 Pilulas"
            )
        )

        mockSchedule.add(
            Schedule(
                name = "Paracetamol",
                time = "12:00 PM",
                duration = "2 weeks",
                dosage = "1 Gota"
            )
        )


        mockSchedule.add(
            Schedule(
                name = "Vigamox",
                time = "12:00 PM",
                duration = "2 weeks",
                dosage = "5 Gotas"
            )
        )
        return mockSchedule
    }
}