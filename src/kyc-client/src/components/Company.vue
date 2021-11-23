<template>
  <div class="box is-primary">
    <h1 class="title has-text-dark">{{ result.name }}</h1>
    <h2 class="subtitle has-text-dark">OrgNr {{ result.number }}</h2>
    <div v-for="(person, index) in result.persons" :key="index">
      <div class="notification is-primary mt-2 mb-2" v-bind:class="{ 'is-danger' : person.pep }">
        <p class="is-size-2">{{ person.name }}</p>
        <p class="is-size-3">{{ person.title }}</p>
        <p class="is-size-4">{{ person.date.year }}-{{ person.date.month }}-{{ person.date.day }}</p>
        <div>
          <div v-for="(dataset, index) in person.dataset" :key="index">
            <p class="is-size-3">{{ dataset.dataset }}</p>
            <p class="is-size-5">{{ dataset.score }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    result: [Object, String, Array]
  }
};
</script>