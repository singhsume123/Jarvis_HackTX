json.array!(@tables) do |table|
  json.extract! table, :id, :status, :capacity, :restaurant_id
  json.url table_url(table, format: :json)
end
