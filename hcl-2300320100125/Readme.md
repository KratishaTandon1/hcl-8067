## 3. Design Note & Class Hierarchy
- **`LibraryItem`**: Abstract base class implementing `Borrowable` and `Comparable`.
- **Subclasses**: `Book`, `Magazine`, and `DVD` extend `LibraryItem` and override `lateFee()`.
- **`InMemoryRepository`**: Generic repository (`<T, ID>`) backed by a `HashMap`.
- **`SearchCache`**: Bounded LRU cache extending `LinkedHashMap`.

Name: Kratisha Tandon (2300320100125)
