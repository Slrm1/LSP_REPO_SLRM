# CSCI 363 & 540 — ATC System CRC Cards

---

## CRC Card 1

Class: TransponderPacket

Responsibilities:
- Hold raw broadcast data from aircraft transponder
- Provide packed bytes for unpacking
- Represent aircraft type and flight data in high-density format

Collaborators (if any):
- PacketUnpacker (receives packet for parsing)

Assumptions (if any):
- Packet format is well-defined and parseable

---

## CRC Card 2

Class: PacketUnpacker

Responsibilities:
- Parse raw TransponderPacket into readable fields
- Extract aircraft type from packet
- Extract flight data (position, altitude, etc.) from packet
- Create AircraftRecord from unpacked data

Collaborators (if any):
- TransponderPacket
- AircraftRecord

Assumptions (if any):
- Packet format is known and stable

---

## CRC Card 3

Class: AircraftRecord

Responsibilities:
- Store aircraft identifier
- Store aircraft type
- Store flight data (position, altitude, heading, etc.)
- Provide getters for display and query

Collaborators (if any):
- (none; data object)

Assumptions (if any):
- Flight data includes position and altitude for conflict detection

---

## CRC Card 4

Class: AircraftDatabase

Responsibilities:
- Store AircraftRecords by aircraft identifier
- Add or update records when new data arrives
- Retrieve record by identifier for controller query
- Return all records for display and conflict analysis

Collaborators (if any):
- AircraftRecord

Assumptions (if any):
- Single airport; database holds only aircraft in range

---

## CRC Card 5

Class: GroundStation

Responsibilities:
- Receive TransponderPacket broadcasts from arriving aircraft
- Delegate unpacking to PacketUnpacker
- Store unpacked AircraftRecords in AircraftDatabase

Collaborators (if any):
- TransponderPacket
- PacketUnpacker
- AircraftDatabase

Assumptions (if any):
- Ground station has hardware/interface to receive transponder broadcasts

---

## CRC Card 6

Class: RadarDisplay

Responsibilities:
- Render aircraft positions on graphics display
- Fetch current data from AircraftDatabase
- Update display with latest aircraft information
- Show aircraft identifiers for controller reference

Collaborators (if any):
- AircraftDatabase
- DisplayScheduler

Assumptions (if any):
- Display is graphical; controller views it in real time

---

## CRC Card 7

Class: DisplayScheduler

Responsibilities:
- Trigger RadarDisplay refresh every 10 seconds
- Notify RadarDisplay when to update
- Maintain refresh interval

Collaborators (if any):
- RadarDisplay

Assumptions (if any):
- 10-second interval is sufficient for controller needs

---

## CRC Card 8

Class: ConflictDetector

Responsibilities:
- Analyze aircraft positions from AircraftDatabase
- Detect proximity violations between aircraft
- Identify dangerous situations (e.g., separation minima)
- Raise alerts when conflicts are detected

Collaborators (if any):
- AircraftDatabase
- AircraftRecord

Assumptions (if any):
- Dangerous situation defined by proximity/altitude thresholds

---

## CRC Card 9

Class: AircraftQuery

Responsibilities:
- Accept aircraft identifier from controller
- Look up aircraft in AircraftDatabase
- Return detailed information for requested plane
- Support query for any plane visible on display

Collaborators (if any):
- AircraftDatabase
- AircraftRecord

Assumptions (if any):
- Controller selects aircraft by identifier shown on display
